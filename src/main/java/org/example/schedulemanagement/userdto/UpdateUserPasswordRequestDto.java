package org.example.schedulemanagement.userdto;

import lombok.Getter;

@Getter
public class UpdateUserPasswordRequestDto {

    private String name;
    private String email;
    private String password;
}
