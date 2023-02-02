package com.onurciner.jdbi3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;
    private String surname;
    private int age;
}