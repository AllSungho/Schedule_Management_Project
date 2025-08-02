package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.entity.Schedule;
import org.example.schedulemanagement.repository.ScheduleRepository;
import org.example.schedulemanagement.scheduledto.FindScheduleResponseDto;
import org.example.schedulemanagement.scheduledto.FindSchedulesResponseDto;
import org.example.schedulemanagement.scheduledto.ScheduleCreateRequestDto;
import org.example.schedulemanagement.scheduledto.ScheduleCreateResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleCreateResponseDto createSchedule(Long userId, ScheduleCreateRequestDto scheduleCreateRequestDto) {

        Schedule schedule = this.scheduleRepository.save(new Schedule(scheduleCreateRequestDto.getTitle(), scheduleCreateRequestDto.getContent(), userId));
        return new ScheduleCreateResponseDto(schedule, schedule.getCreatedAt(), schedule.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<FindSchedulesResponseDto> findSchedules(Long userId) {

        List<Schedule> schedules = this.scheduleRepository.findByUserId(userId);
        return schedules.stream()
                .map(schedule -> new FindSchedulesResponseDto(schedule, schedule.getCreatedAt(), schedule.getModifiedAt()))
                .toList();
    }
    @Transactional(readOnly = true)
    public FindScheduleResponseDto findSchedule(Long userId, Long scheduleId) {

        List<Schedule> schedules = this.scheduleRepository.findByUserId(userId);
        Schedule schedule = schedules.stream().filter(schedule1 -> schedule1.getId().equals(scheduleId)).findFirst().orElseThrow(
                () -> new IllegalArgumentException("일정 아이디가 존재하지 않습니다.")
        );
        return new FindScheduleResponseDto(schedule, schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}