package org.example.schedulemanagement.scheduledto;

import lombok.Getter;
import org.example.schedulemanagement.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleCreateResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleCreateResponseDto(Schedule schedule, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}