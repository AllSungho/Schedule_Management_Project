package org.example.schedulemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.scheduledto.FindScheduleResponseDto;
import org.example.schedulemanagement.scheduledto.FindSchedulesResponseDto;
import org.example.schedulemanagement.scheduledto.ScheduleCreateRequestDto;
import org.example.schedulemanagement.scheduledto.ScheduleCreateResponseDto;
import org.example.schedulemanagement.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/users/{userId}/schedules")
    public ScheduleCreateResponseDto createSchedule(
            @PathVariable Long userId,
            @RequestBody ScheduleCreateRequestDto scheduleCreateRequestDto
    ) {

        return this.scheduleService.createSchedule(userId, scheduleCreateRequestDto);
    }

    @GetMapping("/users/{userId}/schedules")
    public List<FindSchedulesResponseDto> findSchedules(
            @PathVariable Long userId
    ) {

        return this.scheduleService.findSchedules(userId);
    }
    @GetMapping("/users/{userId}/schedules/{scheduleId}")
    public FindScheduleResponseDto findSchedule(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ) {

        return this.scheduleService.findSchedule(userId, scheduleId);
    }
}