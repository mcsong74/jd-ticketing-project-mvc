package com.cybertek.dto;

import com.cybertek.utils.Status;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private String startDate;
    private String endDate;
    private String projectDetails;
    private Status projectStatus;

}
