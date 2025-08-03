package org.example.schedulemanagement.repository;

import org.example.schedulemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    public List<Schedule> findByUserId(Long userId);
    public List<Schedule> findByUserIdOrderByModifiedAtDesc(Long userId);
    public List<Schedule> findByTitleOrderByModifiedAtDesc(String title);
}
