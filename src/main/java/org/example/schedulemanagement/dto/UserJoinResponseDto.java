package org.example.schedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserJoinResponseDto {
    private final Long id;
    private final String name;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UserJoinResponseDto(Long id, String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }
}
