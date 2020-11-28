package com.cybertek.dto;

import com.cybertek.utils.Status;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TaskDTO {
    private String taskId;
    private ProjectDTO project;
    private String taskSubject;
    private UserDTO assignedEmployee;
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm")
    LocalDateTime assignedDate;
    private Status status;
    private String details;
}
