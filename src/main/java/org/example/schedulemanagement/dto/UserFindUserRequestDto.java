package org.example.schedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserFindUserRequestDto {

    private String name;
    private String email;
    private String password;
}
