package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        List<UserDTO> managerList=userService.findAll().stream()
                .filter(user->user.getRole().getDescription().equals("Manager"))
                .collect(Collectors.toList());
        model.addAttribute("managerList", managerList);
        return "/project/create";
    }

    @GetMapping("/status")
    public String projectStatus(){
        return "/project/status";
    }

    @GetMapping("/archived")
    public String archived(){
        return "/project/archived";
    }


}
