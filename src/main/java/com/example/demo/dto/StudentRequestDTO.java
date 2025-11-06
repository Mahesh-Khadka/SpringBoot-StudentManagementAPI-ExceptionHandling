package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "RollNo is required")
    private String rollNo;

    @NotBlank(message = "Faculty is required.")
    private String faculty;

    @NotBlank(message = "semester is required")
    private String semester;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "email is required")
    @Email(message = "Enter a correct email")
    private String email;
}
