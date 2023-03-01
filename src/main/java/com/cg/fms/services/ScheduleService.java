package com.cg.fms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ScheduleDao;
import com.cg.fms.entities.Schedule;
import com.cg.fms.exceptions.NoScheduleFoundException;
import com.cg.fms.exceptions.ScheduleIdNotMatchException;

@Service("scheduleService")
public class ScheduleService {
	
	@Autowired
	ScheduleDao sdao;
	
	public Schedule createSchedule (Schedule schedule) {
		return sdao.save(schedule);
	}
	
	
	public Schedule modifySchedule (long sid, Schedule schedule) {
		if(sid==schedule.getSid()) {
			if(sdao.existsById(sid)) {
				return sdao.save(schedule);
			}else
				throw new NoScheduleFoundException(
						"Schedule with Sid: " + schedule.getSid() + " Not Present!!");		
		}
		throw new ScheduleIdNotMatchException("ScheduleId not Matched");	
		
	}
	
	
	public Schedule viewSchedule(long sid){
		Optional<Schedule> findById =sdao.findById(sid);
		if(findById.isPresent()) {
			
			return findById.get();
		}
		else 
			throw new NoScheduleFoundException("No ScheduleID found with ID: "+ sid);
	}
	
	public List<Schedule> viewAllSchedule(){
		List<Schedule> list =sdao.findAll();
		if(list.isEmpty()) {
			throw new NoScheduleFoundException("No ScheduleID found");
		}
		else 
			return list;
	}
	
	public String deleteSchedule(long sid)
	{
		Optional<Schedule> findById = sdao.findById(sid);
		if(findById.isPresent()) {
				sdao.deleteById(sid);
				return "Deletion Success with id - " +sid;
		}else {
			throw new NoScheduleFoundException("No Record Found with id - "+ sid +" To Delete");
		}
		
		
		
		
		
		
	}
	
//	public List<Schedule> viewScheduleBySDD(String src, String dst) {
//		List<Schedule> sc1 = sdao.findAll();
////		List<Schedule> sc2 = new ArrayList<>();
//		
//		for(Schedule s : sc1)
//		{
//			if(s.getSourceAirport().getAirportLocation().equals(src) && 
//					s.getDestinationAirport().getAirportLocation().equals(dst))
//					
//			{
//				//add scheduled flight in the list if it is between the given airports & available seats !=0
//				sc2.add(s);
//			}
//			
//		}
//		if (sc2.size()==0) {
//			//throw exception if not scheduled flight found
//			throw new NoScheduleFoundException("No Schedule found "+" of "+date);
//		}
//		return sc2;
	}


