package com.cybertek.entity;

import lombok.*;

import javax.validation.constraints.NegativeOrZero;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    private Long id;
    private String description;

}
