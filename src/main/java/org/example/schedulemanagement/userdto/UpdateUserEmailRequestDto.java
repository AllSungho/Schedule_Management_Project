package org.example.schedulemanagement.userdto;

import lombok.Getter;

@Getter
public class UpdateUserEmailRequestDto {

    private String name;
    private String email;
    private String password;
}
