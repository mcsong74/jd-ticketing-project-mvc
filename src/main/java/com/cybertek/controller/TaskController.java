package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import com.cybertek.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public String createTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findAll().stream()
                .filter(user -> user.getRole().getDescription().equals("Employee"))
                .collect(Collectors.toList()));
        model.addAttribute("tasklist", taskService.findAll());
        return "/task/create";
    }

    @PostMapping("/create")
    public String addTask(TaskDTO task, Model model) {
        task.setTaskId("TASK-" + (taskService.findAll().stream().count() + 1l));
        task.setAssignedDate(LocalDateTime.now());
        taskService.save(task);
        task.setStatus(Status.OPEN);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTask(TaskDTO task){
        taskService.deleteById(task.getTaskId());
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") String taskId, Model model){
        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findAll().stream()
                .filter(user -> user.getRole().getDescription().equals("Employee"))
                .collect(Collectors.toList()));
        model.addAttribute("tasklist", taskService.findAll());
        return "/task/update";
    }
    @PostMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId")String taskId, TaskDTO task){
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
