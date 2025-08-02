package org.example.schedulemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.userdto.*;
import org.example.schedulemanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserJoinResponseDto userJoin(
            @RequestBody UserJoinRequestDto userJoinRequestDto
    ) {

        return this.userService.userJoin(userJoinRequestDto);
    }

    @GetMapping("/users")
    public List<UserFindUsersResponseDto> findUsers() {

        return this.userService.findUsers();
    }
    @GetMapping("/users/{userId}")
    public UserFindUserResponseDto findUser(
            @PathVariable Long userId
    ) {

        return this.userService.findUser(userId);
    }

    @PutMapping("/users/{userId}/names")
    public UpdateUserNameResponseDto updateUserName(
            @PathVariable Long userId,
            @RequestBody UpdateUserNameRequestDto updateUserNameRequestDto
    ) {

        return this.userService.updateUserName(userId, updateUserNameRequestDto);
    }
    @PutMapping("/users/{userId}/emails")
    public UpdateUserEmailResponseDto updateUserEmail(
            @PathVariable Long userId,
            @RequestBody UpdateUserEmailRequestDto updateUserEmailRequestDto
    ) {

        return this.userService.updateUserEmail(userId, updateUserEmailRequestDto);
    }
    @PutMapping("/users/{userId}/passwords")
    public UpdateUserPasswordResponseDto updateUserPassword(
            @PathVariable Long userId,
            @RequestBody UpdateUserPasswordRequestDto updateUserPasswordRequestDto
    ) {

        return this.userService.updateUserPassword(userId, updateUserPasswordRequestDto);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(
            @PathVariable Long userId
    ) {

        this.userService.deleteUser(userId);
    }
}
