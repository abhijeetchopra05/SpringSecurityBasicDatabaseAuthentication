package com.springsecurity.basicDatabaseAuthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuredResources {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
