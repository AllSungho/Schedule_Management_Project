package org.example.schedulemanagement.userdto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FindUserResponseDto {

    private Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public FindUserResponseDto(Long id, String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt =  createdAt;
        this.updatedAt = updatedAt;
    }
}
