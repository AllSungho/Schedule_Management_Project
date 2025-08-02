package org.example.schedulemanagement.scheduledto;

import lombok.Getter;
import org.example.schedulemanagement.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class FindSchedulesResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final Long userId;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;

    public FindSchedulesResponseDto(Schedule schedule, LocalDateTime createAt, LocalDateTime updateAt) {

        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.userId = schedule.getUserId();
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
