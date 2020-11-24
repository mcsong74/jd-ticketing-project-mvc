package com.cybertek.controller;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    //    @GetMapping({"/create", "/add", "initialize"})  //{} represent list
    @GetMapping("/create")  //{} represent list
    public String createUser(Model model) {
        userService.findAll().stream().forEach(user -> System.out.println(user.toString()));
//        System.out.println(userService.findAll().toString());
        model.addAttribute("user", new UserDTO());
        model.addAttribute("rolelist",roleService.findAll());
        model.addAttribute("userlist", userService.findAll());
        return ("/user/create");

    }



//    @PostMapping("/create")
//    public String listUser(@ModelAttribute("user") UserDTO user){
//        roleService.save(user.getRole());
//        userService.save(user);
//        userService.findAll().stream().forEach(u -> System.out.println(u.toString()));
//
//        return("/user/create");
//    }

}
