package com.dariawan.poc.controller;

import com.dariawan.poc.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "dariawan/hello", method = RequestMethod.GET)
    @ResponseBody
    public Hello sayHello() {
        Hello hello = new Hello();
        hello.setHelloFrom("Dariawan");
        hello.setHelloMessage("Greetings!");
        return hello;
    }
}
