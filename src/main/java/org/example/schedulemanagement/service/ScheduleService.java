package org.example.schedulemanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.entity.Schedule;
import org.example.schedulemanagement.repository.ScheduleRepository;
import org.example.schedulemanagement.scheduledto.*;
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

    @Transactional
    public UpdateScheduleTitleResponseDto updateScheduleTitle(Long userId, Long scheduleId, UpdateScheduleTitleRequestDto updateScheduleTitleRequestDto) {

        List<Schedule> schedules = this.scheduleRepository.findByUserId(userId);
        Schedule schedule = schedules.stream().filter(schedule1 -> schedule1.getId().equals(scheduleId)).findFirst().orElseThrow(
                () -> new IllegalArgumentException("일정 아이디가 존재하지 않습니다.")
        );
        schedule.updateTitle(updateScheduleTitleRequestDto.getTitle());
        return new UpdateScheduleTitleResponseDto(schedule, schedule.getModifiedAt(), schedule.getModifiedAt());
    }
    @Transactional
    public UpdateScheduleContentResponseDto updateScheduleContent(Long userId, Long scheduleId, UpdateScheduleContentRequestDto updateScheduleContentRequestDto) {

        List<Schedule> schedules = this.scheduleRepository.findByUserId(userId);
        Schedule schedule = schedules.stream().filter(schedule1 -> schedule1.getId().equals(scheduleId)).findFirst().orElseThrow(
                () -> new IllegalArgumentException("일정 아이디가 존재하지 않습니다.")
        );
        schedule.updateContent(updateScheduleContentRequestDto.getContent());
        return new UpdateScheduleContentResponseDto(schedule, schedule.getModifiedAt(), schedule.getModifiedAt());
    }

    @Transactional
    public void deleteSchedule(Long userId, Long scheduleId) {
        List<Schedule> schedules = this.scheduleRepository.findByUserId(userId);
        schedules.stream().filter(schedule1 -> schedule1.getId().equals(scheduleId)).findFirst().orElseThrow(
                () -> new IllegalArgumentException("일정 아이디가 존재하지 않습니다.")
        );
        scheduleRepository.deleteById(scheduleId);
    }
}