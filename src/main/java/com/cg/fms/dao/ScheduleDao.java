package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Long>{
	
}