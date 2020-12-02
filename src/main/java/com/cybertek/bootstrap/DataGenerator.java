package com.cybertek.bootstrap;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.service.ProjectService;
import com.cybertek.service.RoleService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import com.cybertek.utils.Gender;
import com.cybertek.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataGenerator implements CommandLineRunner {

//    RoleServiceImpl roleService;
    RoleService roleService; //always bind through interface
    UserService userService;
    ProjectService projectService;
    TaskService taskService;
    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService,
                         TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService=taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this will run when the application is running
        RoleDTO adminRole=new RoleDTO(1l, "Admin");
        RoleDTO managerRole=new RoleDTO(2l, "Manager");
        RoleDTO employeeRole=new RoleDTO(3l, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cybertek.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cybertek.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cybertek.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cybertek.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cybertek.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cybertek.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cybertek.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cybertek.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDTO project1=new ProjectDTO("Spring MVC", "PRJ001", user2, LocalDate.now(),
                LocalDate.now().plusDays(25),"Spring MVC Project - creating controller", Status.OPEN);
        ProjectDTO project2=new ProjectDTO("Spring ORM", "PRJ002", user1, LocalDate.now(),
                LocalDate.now().plusDays(35),"Spring MVC Project - creating Database", Status.IN_PROGRESS);
        ProjectDTO project3=new ProjectDTO("Spring Container", "PRJ003", user1, LocalDate.now(),
                LocalDate.now().plusDays(60),"Spring MVC Project - creating Database", Status.UAT_TEST);
        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDTO task1 = new TaskDTO(project1,"Controller",user8,LocalDate.now().minusDays(4),Status.IN_PROGRESS,"Request Mapping");
        TaskDTO task2 = new TaskDTO(project3,"Configuration",user3,LocalDate.now().minusDays(12),Status.COMPLETE,"Database Connnection");
        TaskDTO task3 = new TaskDTO(project3,"Mapping",user6,LocalDate.now().minusDays(8),Status.IN_PROGRESS,"One-To-Many");
        TaskDTO task4 = new TaskDTO(project2,"Dependency Injection",user7,LocalDate.now().minusDays(20),Status.UAT_TEST,"Autowired");
        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

//        TaskDTO task1= new TaskDTO(1l, project1, "Database Connection", user6, LocalDateTime.of(2020, 11, 01,
//                18,12),
//                Status.IN_PROGRESS, "Task assigned for project 1");
//        TaskDTO task2= new TaskDTO(2l, project2, "Server LAN Setting", user6, LocalDateTime.of(2020, 11, 02,
//                18,12),
//                Status.UAT_TEST  ,"Task assigned for project 1");
//        TaskDTO task3= new TaskDTO(3l,project1, "REST Codes Development", user7, LocalDateTime.of(2020, 10,
//                18, 18, 12),
//                 Status.COMPLETE   ,"Task assigned for project 1");
//        TaskDTO task4= new TaskDTO(4l,project1, "Database Connection", user8, LocalDateTime.of(2020, 11, 01,
//                18, 12),
//                 Status.OPEN  ,"Task assigned for project 1");
//        TaskDTO task5= new TaskDTO(5l,project1, "Database Connection", user7, LocalDateTime.of(2020, 11, 01,
//                18, 12),
//                 Status.COMPLETE ,"Task assigned for project 1");
//
//        taskService.save(task1);
//        taskService.save(task2);
//        taskService.save(task3);
//        taskService.save(task4);
//        taskService.save(task5);


        //        roleService.findAll().stream().forEach(r-> System.out.println(r.toString()));
//        UserDTO user6 = new UserDTO("Delisa",
//                "Norre", "T001@cybertek.com", "123Update", true, "8567412358", managerRole, Gender.FEMALE);
//        userService.update(user6.getUserName(), user6);

    }
}
