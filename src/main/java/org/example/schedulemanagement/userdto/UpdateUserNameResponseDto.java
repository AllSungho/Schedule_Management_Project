package org.example.schedulemanagement.userdto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserNameResponseDto {

    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UpdateUserNameResponseDto(String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
