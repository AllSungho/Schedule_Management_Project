package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.entity.Schedule;
import org.example.schedulemanagement.repository.ScheduleRepository;
import org.example.schedulemanagement.scheduledto.ScheduleCreateRequestDto;
import org.example.schedulemanagement.scheduledto.ScheduleCreateResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleCreateResponseDto createSchedule(Long userId, ScheduleCreateRequestDto scheduleCreateRequestDto) {

        Schedule schedule = this.scheduleRepository.save(new Schedule(scheduleCreateRequestDto.getTitle(), scheduleCreateRequestDto.getContent(), userId));
        return new ScheduleCreateResponseDto(schedule, schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}