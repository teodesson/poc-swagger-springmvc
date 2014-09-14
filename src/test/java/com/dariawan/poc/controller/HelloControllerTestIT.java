package com.dariawan.poc.controller;

import static com.jayway.restassured.RestAssured.with;
import java.net.InetAddress;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Desson Ariawan <teodesson@yahoo.com>
 */
public class HelloControllerTestIT {

    protected String target = "http://{serverName}:9699/dariawan/hello";
    protected String login = "http://{serverName}:9699/j_spring_security_check";
    
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
                .expect()
                .statusCode(200)
                .body("helloFrom", equalTo("Dariawan"), "helloMessage", equalTo("Greetings!"))
                .when().get(target);
    }
}
