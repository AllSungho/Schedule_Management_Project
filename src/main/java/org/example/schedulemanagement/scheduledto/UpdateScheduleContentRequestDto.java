package org.example.schedulemanagement.scheduledto;

import lombok.Getter;
import org.example.schedulemanagement.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleContentRequestDto {

    private String content;
}
