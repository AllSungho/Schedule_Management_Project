package org.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class UpdateUserPasswordRequestDto {

    private Long id;
    private String name;
    private String email;
    private String createdAt;
    private String updatedAt;
}
