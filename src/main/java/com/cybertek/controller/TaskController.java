package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.RoleService;
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
import java.util.UUID;


@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @Autowired
    RoleService roleService;

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
//        task.setId((long) (taskService.findAll().size()+1));
        task.setId(UUID.randomUUID().getMostSignificantBits());
        task.setAssignedDate(LocalDate.now());
        task.setStatus(Status.OPEN);

        taskService.save(task);


        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(TaskDTO task){
        taskService.deleteById(task.getId());
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findEmployees());
        model.addAttribute("tasklist", taskService.findAll());
        return "/task/update";
    }
    @PostMapping("/update/{id}")
    public String editTask(TaskDTO task){
//        task.setStatus(taskService.findById(id).getStatus());     //implemented to TaskServiceImpl
//        task.setAssignedDate(taskService.findById(id).getAssignedDate()); //implemented to TaskServiceImpl
        taskService.updateByObj(task);

        return "redirect:/task/create";
    }
    @GetMapping("/pending")
    public String pendingTasks(Model model) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findEmployees());
        model.addAttribute("statuslist", roleService.findAll());
        model.addAttribute("tasklist", taskService.findAll());
        return "/employee/pending";
    }
    @GetMapping("/pending/update/{id}")
    public String editPendingTask(@PathVariable("id") Long id, Model model){
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projectlist", projectService.findAll());
        model.addAttribute("employeelist", userService.findEmployees());
        model.addAttribute("statuslist", roleService.findAll());
        model.addAttribute("tasklist", taskService.findAll());
        return "/employee/update";
    }
    @PostMapping("/pending/update/{id}")
    public String updatePendingTask(TaskDTO task){
        System.out.println(task.toString());
        taskService.updateByObj(task);

        return "redirect:/employee/pending";
    }

    @GetMapping("/archived")
    public String archived(){
        return "/employee/archived";
    }

}
