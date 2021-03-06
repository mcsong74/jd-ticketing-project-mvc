package com.cybertek.controller;

import com.cybertek.dto.UserDTO;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
//    @Autowired
    RoleService roleService;
//    @Autowired
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    //    @GetMapping({"/create", "/add", "initialize"})  //{} represent list
    @GetMapping("/create")  //{} represent list
    public String createUser(Model model) {
//        userService.findAll().stream().forEach(user -> System.out.println(user.toString()));
//        System.out.println(userService.findAll().toString());
        model.addAttribute("user", new UserDTO());
        model.addAttribute("rolelist",roleService.findAll());
        model.addAttribute("userlist", userService.findAll());

        return ("/user/create");

    }

    @PostMapping("/create")
    public String insertUser(UserDTO user,  Model model){

        userService.save(user);

        //user, rolelist, userlist object need to pass to view
//        model.addAttribute("user", new UserDTO()); //is for new form after hit save button
//        model.addAttribute("rolelist", roleService.findAll());
//        model.addAttribute("userlist", userService.findAll());
        return("redirect:/user/create"); //redirect and removed redundancy of same code block
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){
        model.addAttribute("user", userService.findById(username));
        model.addAttribute("userlist", userService.findAll());
        model.addAttribute("rolelist", roleService.findAll());
        return "/user/update";
    }
    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user, Model model){
        userService.updateByObj(user);

//        model.addAttribute("user", new UserDTO()); //is for new form after hit save button
//        model.addAttribute("rolelist", roleService.findAll());
//        model.addAttribute("userlist", userService.findAll());
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteById(username);
        return "redirect:/user/create";
    }

}
