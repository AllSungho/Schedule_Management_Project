package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.userdto.*;
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
    public UserFindUserResponseDto findUser(Long id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        return new UserFindUserResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public UpdateUserNameResponseDto updateUserName(Long id, UpdateUserNameRequestDto updateUserNameRequestDto) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        user.changeName(updateUserNameRequestDto.getName());
        return new UpdateUserNameResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public UpdateUserEmailResponseDto updateUserEmail(Long id, UpdateUserEmailRequestDto updateUserEmailRequestDto) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        user.changeEmail(updateUserEmailRequestDto.getEmail());
        return new UpdateUserEmailResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public UpdateUserPasswordResponseDto updateUserPassword(Long id, UpdateUserPasswordRequestDto updateUserPasswordRequestDto) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        user.changePassword(updateUserPasswordRequestDto.getPassword());
        return new UpdateUserPasswordResponseDto(user.getName(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt());
    }
    @Transactional
    public void deleteUser(Long id) {

        userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        userRepository.deleteById(id);
    }
}
