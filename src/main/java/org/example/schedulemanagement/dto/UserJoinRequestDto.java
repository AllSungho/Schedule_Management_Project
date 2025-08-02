package org.example.schedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserJoinRequestDto {

    private String name;
    private String email;
    private String password;
}
