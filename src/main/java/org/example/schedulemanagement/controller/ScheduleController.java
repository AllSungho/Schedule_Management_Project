package org.example.schedulemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.scheduledto.ScheduleCreateRequestDto;
import org.example.schedulemanagement.scheduledto.ScheduleCreateResponseDto;
import org.example.schedulemanagement.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/users/{userId}/Schedules")
    public ScheduleCreateResponseDto createSchedule(
            @PathVariable Long userId,
            @RequestBody ScheduleCreateRequestDto scheduleCreateRequestDto
    ) {

        return this.scheduleService.createSchedule(userId, scheduleCreateRequestDto);
    }
}