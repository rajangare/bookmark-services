package com.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto implements Serializable {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private LocalDateTime creationDate;

    private LocalDateTime modifiedDate;
}
