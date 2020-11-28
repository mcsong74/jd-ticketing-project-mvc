package com.cybertek.dto;

import com.cybertek.utils.Status;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TaskDTO {
    private ProjectDTO project;
    private String taskSubject;
    private UserDTO assignedEmployee;
    LocalDateTime assignedDate;
    private Status status;
    private String details;
}
