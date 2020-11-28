package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findAll().stream()
                .filter(user->user.getRole().getDescription().equals("Employee"))
                .collect(Collectors.toList()));
        model.addAttribute("tasklist", taskService.findAll());
        return "/task/create";
    }

    @GetMapping("/pending")
    public String pendingTasks(){
        return "/task/pending";
    }


}
