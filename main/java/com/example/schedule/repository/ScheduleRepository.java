package com.example.schedule.repository;

import com.example.schedule.dto.DeleteScheduleRequest;
import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
