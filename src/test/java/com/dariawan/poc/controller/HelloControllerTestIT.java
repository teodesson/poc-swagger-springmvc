package com.dariawan.poc.controller;

import static com.jayway.restassured.RestAssured.with;
import com.jayway.restassured.authentication.FormAuthConfig;
import java.net.InetAddress;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Desson Ariawan <teodesson@yahoo.com>
 */
public class HelloControllerTestIT {

    protected static final String username = "root";
    protected static final String password = "admin";

    protected String login = "http://{serverName}:9699/j_spring_security_check";
    protected String target = "http://{serverName}:9699/dariawan/hello";
    
    @Before
    public void changeTarget() throws Exception {
        String computerName = InetAddress.getLocalHost().getHostName();
        if (computerName.equals("")) {
            computerName = "localhost";
        }
        target = target.replace("{serverName}", computerName);
        login = login.replace("{serverName}", computerName);
    }
    
    @Test
    public void testSayHello() {
        with().header("Accept", "application/json")
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect()
                .statusCode(200)
                .body("helloFrom", equalTo("Dariawan"), "helloMessage", equalTo("Greetings!"))
                .when().get(target +"/getHello");
    }
    
    @Test
    public void testSayHelloAsString() {
        
        //System.out.println(with()
        //    .contentType("application/json").get(target +"/getString").getBody().asString());        

        with().header("Accept", "application/json")
                .auth().form(username, password, new FormAuthConfig(login, "j_username", "j_password"))
                .expect()
                .statusCode(200)
                .body(equalTo("Greetings from Dariawan!"))
                .when().get(target +"/getString");
    }
}
