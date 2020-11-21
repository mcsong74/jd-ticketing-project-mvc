package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NegativeOrZero;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    private Long id;
    private String description;

}
