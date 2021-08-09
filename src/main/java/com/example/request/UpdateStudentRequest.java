package com.example.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {
    @NotNull
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
