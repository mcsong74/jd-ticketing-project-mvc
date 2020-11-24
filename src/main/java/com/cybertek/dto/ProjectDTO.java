package com.cybertek.dto;

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
    private String assignedManager;
    private String startDate;
    private String endDate;
    private String projectDetails;

}
