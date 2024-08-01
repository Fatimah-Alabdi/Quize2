package com.example.quize2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teeacher {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannnot be empty")
    private String name;
    @NotNull(message = "salary cannot be null")
    private int salary;
}
