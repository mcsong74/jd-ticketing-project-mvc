package com.cybertek.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/create", "/add", "initialize"})  //{} represent list
    public String createUser(){
        return ("/user/create");

    }

}
