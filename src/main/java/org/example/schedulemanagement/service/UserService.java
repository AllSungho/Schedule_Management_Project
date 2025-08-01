package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.dto.UserJoinRequestDto;
import org.example.schedulemanagement.dto.UserJoinResponseDto;
import org.example.schedulemanagement.entity.User;
import org.example.schedulemanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
}
