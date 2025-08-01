package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.dto.*;
import org.example.schedulemanagement.entity.User;
import org.example.schedulemanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserJoinResponseDto userJoin(UserJoinRequestDto userJoinRequestDto) {
        User user = userRepository.save(
                new User(
                        userJoinRequestDto.getName(),
                        userJoinRequestDto.getEmail(),
                        userJoinRequestDto.getPassword()
                )
        );
        System.out.println("User = " + user.getId());
        return new UserJoinResponseDto(
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
    @Transactional(readOnly = true)
    public List<UserFindUsersResponseDto> findUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserFindUsersResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt()))
                        .toList();
    }
    @Transactional(readOnly = true)
    public UserFindUserResponseDto findUserByEmail(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        return new UserFindUserResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public UpdateUserNameResponseDto updateUserName(Long id, String name) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        user.changeName(name);
        return new UpdateUserNameResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public UpdateUserEmailResponseDto updateUserEmail(Long id, String email) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        user.changeEmail(email);
        return new UpdateUserEmailResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public UpdateUserPasswordResponseDto updateUserPassword(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        user.changePassword(password);
        return new UpdateUserPasswordResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
}
