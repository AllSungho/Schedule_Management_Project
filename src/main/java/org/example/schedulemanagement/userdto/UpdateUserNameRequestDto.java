package org.example.schedulemanagement.userdto;

import lombok.Getter;

@Getter
public class UpdateUserNameRequestDto {

    private String name;
    private String email;
    private String password;
}
