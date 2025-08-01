package org.example.schedulemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.dto.UserJoinRequestDto;
import org.example.schedulemanagement.dto.UserJoinResponseDto;
import org.example.schedulemanagement.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserJoinResponseDto userJoin(
            @RequestBody UserJoinRequestDto userJoinRequestDto
    ) {
        return userService.userJoin(userJoinRequestDto);
    }
}
