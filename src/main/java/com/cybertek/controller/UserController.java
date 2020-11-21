package com.cybertek.controller;

import com.cybertek.dto.UserDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    //    @GetMapping({"/create", "/add", "initialize"})  //{} represent list
    @GetMapping("/create")  //{} represent list
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return ("/user/create");

    }

    @PostMapping("/create")
    public String postUser(){
        return("/user/create");
    }

}
