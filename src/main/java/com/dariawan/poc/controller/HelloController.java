package com.dariawan.poc.controller;

import com.dariawan.poc.model.Hello;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/")
@Api(value = "/", description = "apis for Hello")
public class HelloController {

    
    @RequestMapping(value = "dariawan/hello/getHello", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Greetings using Swagger, return Hello", notes = "return Hello", response = Hello.class)
    @ResponseStatus(HttpStatus.OK)
    public Hello sayHello() {
        Hello hello = new Hello();
        hello.setHelloFrom("Dariawan");
        hello.setHelloMessage("Greetings!");
        return hello;
    }
    
    @RequestMapping(value = "dariawan/hello/sayHello/{from}/{message}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Greetings using Swagger, return Hello", notes = "return Hello", response = Hello.class)
    @ResponseStatus(HttpStatus.OK)
    public Hello sayHello(
            @ApiParam(name = "from", value = "greetings from?", required = true) @PathVariable("from") String from, 
            @ApiParam(name = "message", value = "greeting message?", required = true) @PathVariable("message") String message) {
        Hello hello = new Hello();
        hello.setHelloFrom(from);
        hello.setHelloMessage(message);
        return hello;
    }
    
    /**
     * 
     * @return greetings
     */
    @RequestMapping(value = "dariawan/hello/getString", method = RequestMethod.GET)
    @ApiOperation(value = "Greetings using Swagger, return String", notes = "return Hello as String", response = String.class)
    public String sayHelloAsString() {
        return "Greetings from Dariawan!";
    }
}
