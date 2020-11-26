package com.cybertek.bootstrap;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.implementation.RoleServiceImpl;
import com.cybertek.service.ProjectService;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import com.cybertek.utils.Gender;
import com.cybertek.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

//    RoleServiceImpl roleService;
    RoleService roleService; //always bind through interface
    UserService userService;
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
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
                "admin@cybertek.com", "abc", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user5 = new UserDTO("John", "Kesy",
                "admin2@cybertek.com", "abc", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "T001@cybertek.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "P001@cybertek.com", "123", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "S001@cybertek.com", "123", true, "3256987412", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);

        ProjectDTO project1=new ProjectDTO("Spring MVC", "PRJ001", user2, LocalDate.now(),
                LocalDate.now().plusDays(25),"Spring MVC Project - creating controller", Status.OPEN);
        ProjectDTO project2=new ProjectDTO("Spring ORM", "PRJ002", user1, LocalDate.now(),
                LocalDate.now().plusDays(35),"Spring MVC Project - creating Database", Status.IN_PROGRESS);
        ProjectDTO project3=new ProjectDTO("Spring Container", "PRJ002", user2, LocalDate.now(),
                LocalDate.now().plusDays(60),"Spring MVC Project - creating Database", Status.UAT_TEST);
        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
        //        roleService.findAll().stream().forEach(r-> System.out.println(r.toString()));
//        UserDTO user6 = new UserDTO("Delisa",
//                "Norre", "T001@cybertek.com", "123Update", true, "8567412358", managerRole, Gender.FEMALE);
//        userService.update(user6.getUserName(), user6);

    }
}
