package com.dariawan.poc.controller;

import com.dariawan.poc.model.Hello;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "dariawan/hello/getHello", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Greetings using Swagger, return Hello")
    @ResponseBody
    public Hello sayHello() {
        Hello hello = new Hello();
        hello.setHelloFrom("Dariawan");
        hello.setHelloMessage("Greetings!");
        return hello;
    }
    
    /**
     * using swagger-springmvc 0.6.5 this function failed to return result in swagger-ui, 
     * but can pass integration testing
     * 
     * @return greetings
     */
    @RequestMapping(value = "dariawan/hello/getString", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Greetings using Swagger, return String")
    @ResponseBody
    public String sayHelloAsString() {
        return "Greetings from Dariawan!";
    }
}
