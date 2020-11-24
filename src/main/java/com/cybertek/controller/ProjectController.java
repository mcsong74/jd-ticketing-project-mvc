package com.cybertek.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @GetMapping("/create")
    public String createProject(Model model){
//        model.addAttribute("project", )
        return "/project/create";
    }


}
