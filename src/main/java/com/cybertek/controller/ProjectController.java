package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;

import com.cybertek.service.ProjectService;
import com.cybertek.service.UserService;
import com.cybertek.utils.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
//        List<UserDTO> managerList=userService.findAll().stream()
//                .filter(user->user.getRole().getDescription().equals("Manager"))
//                .collect(Collectors.toList());
//        model.addAttribute("managerList", managerList);
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managerList", userService.findAll().stream()
                .filter(user->user.getRole().getDescription().equals("Manager"))
                .collect(Collectors.toList()));
        model.addAttribute("projectlist", projectService.findAll());

        return "/project/create";
    }
    @PostMapping("/create")
    public String insertProject(ProjectDTO project){
        projectService.save(project);
        project.setProjectStatus(Status.OPEN);
        return "redirect:/project/create";
    }
    @GetMapping("/delete/{projectcode}")
    public String deleteProject(@PathVariable("projectcode") String projectcode){
        projectService.deleteById(projectcode);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectcode, Model model){
        model.addAttribute("project", projectService.findById(projectcode));
        model.addAttribute("managerlist", userService.findManagers());
//        model.addAttribute("managerlist", userService.findAll().stream()
//                .filter(user->user.getRole().getDescription().equals("Manager"))
//                .collect(Collectors.toList()));
        model.addAttribute("projectlist", projectService.findAll());
        return "/project/update";
    }

    @PostMapping("/update/{projectcode}")
    public String updateProject(@PathVariable("projectcode") String projectcode, ProjectDTO project){
//        project.setProjectStatus(projectService.findById(projectcode).getProjectStatus()); //implemented to service
        projectService.updateByObj(project);
        //redirect replaced below commented
//        model.addAttribute("project", new ProjectDTO());
//        model.addAttribute("managerlist", userService.findAll().stream()
//                .filter(user->user.getRole().getDescription().equals("Manager"))
//                .collect(Collectors.toList()));
//        model.addAttribute("projectlist", projectService.findAll());
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectcode){
//        projectService.findById(projectcode).setProjectStatus(Status.COMPLETE);
        projectService.complete(projectService.findById(projectcode));
        return "redirect:/project/create";
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
