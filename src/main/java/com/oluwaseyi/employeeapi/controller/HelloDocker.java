package com.oluwaseyi.employeeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDocker {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Docker";
    }
}
