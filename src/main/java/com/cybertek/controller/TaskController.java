package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import com.cybertek.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
    public String createTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findEmployees());
        model.addAttribute("tasklist", taskService.findAll());
        return "/task/create";
    }

    @PostMapping("/create")
    public String addTask(TaskDTO task, Model model) {
        task.setId((long) (taskService.findAll().size()+1));
        task.setAssignedDate(LocalDate.now());
        taskService.save(task);
        task.setStatus(Status.OPEN);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTask(TaskDTO task){
        taskService.deleteById(task.getId());
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model){
        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findEmployees());
        model.addAttribute("tasklist", taskService.findAll());
        return "/task/update";
    }
    @PostMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, TaskDTO task){
        task.setStatus(taskService.findById(taskId).getStatus());
        task.setAssignedDate(taskService.findById(taskId).getAssignedDate());
        taskService.updateByObj(task);

        return "redirect:/task/create";
    }
    @GetMapping("/pending")
    public String pendingTasks() {
        return "/task/pending";
    }


}
