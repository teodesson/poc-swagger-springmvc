package com.dariawan.poc.controller;

import com.dariawan.poc.model.Hello;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "dariawan/hello", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Greetings using Swagger")
    @ResponseBody
    public Hello sayHello() {
        Hello hello = new Hello();
        hello.setHelloFrom("Dariawan");
        hello.setHelloMessage("Greetings!");
        return hello;
    }
}
