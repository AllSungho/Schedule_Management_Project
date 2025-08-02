package org.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class UpdateUserPasswordRequestDto {

    private String name;
    private String email;
    private String password;
}
