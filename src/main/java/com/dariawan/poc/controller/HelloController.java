package com.dariawan.poc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "dariawan/hello")
    public String sayHello() {
        return "Greetings from Dariawan! ";
    }
}
