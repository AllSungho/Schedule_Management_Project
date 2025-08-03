package org.example.schedulemanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulemanagement.scheduledto.*;
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
            @PathVariable Long userId,
            @RequestParam(name = "title", required = false) String title
    ) {

        if (title == null) {
            return this.scheduleService.findSchedules(userId);
        }
        else {
            return this.scheduleService.findSchedules(title);
        }
    }
    @GetMapping("/users/{userId}/schedules/{scheduleId}")
    public FindScheduleResponseDto findSchedule(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ) {

        return this.scheduleService.findSchedule(userId, scheduleId);
    }

    @PatchMapping("/users/{userId}/schedules/{scheduleId}/titles")
    public UpdateScheduleTitleResponseDto updateScheduleTitle(
            @PathVariable Long userId,
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleTitleRequestDto updateScheduleTitleRequestDto
    ) {

        return this.scheduleService.updateScheduleTitle(
                userId,
                scheduleId,
                updateScheduleTitleRequestDto
        );
    }
    @PatchMapping("/users/{userId}/schedules/{scheduleId}/contents")
    public UpdateScheduleContentResponseDto updateScheduleContent(
            @PathVariable Long userId,
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleContentRequestDto updateScheduleContentRequestDto
    ) {

        return this.scheduleService.updateScheduleContent(
                userId,
                scheduleId,
                updateScheduleContentRequestDto
        );
    }

    @DeleteMapping("/users/{userId}/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable Long userId,
            @PathVariable Long scheduleId
    ) {

        this.scheduleService.deleteSchedule(userId, scheduleId);
    }
}