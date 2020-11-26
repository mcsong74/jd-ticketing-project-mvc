package com.cybertek.dto;

import com.cybertek.utils.Status;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetails;
    private Status projectStatus;

}
