package org.example.schedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserPasswordResponseDto {

    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UpdateUserPasswordResponseDto(String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
