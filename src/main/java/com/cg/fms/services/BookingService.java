package com.cg.fms.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.dao.*;
import com.cg.fms.entities.*;
import com.cg.fms.exceptions.*;


@Service("bookingService")
@Transactional
public class BookingService
{

	@Autowired
	BookingDao bdao;
	
	public Booking createNewBooking(Booking newBooking)
	{
           return bdao.save(newBooking);
	}
	//need to review
	public Booking updateBooking(long bookingId,Booking newBooking)
	{
		if(bookingId==newBooking.getBookingId()) {
			if(bdao.existsById(bookingId)) {
				return bdao.save(newBooking);
			}else
				throw new NoRecordFoundException(
						"Booking with BookingId: " + newBooking.getBookingId() + " Not Present!!");		
		}
		throw new IdNotMatchException(
				"BookindId not Matched(Enter bookingid field, Ex:"+" bookingid:id");	
		
	}
	
	public Booking viewBooking(long bookingId)
	{
		Optional<Booking> findById = bdao.findById(bookingId);
		if (findById.isPresent()) {
			return findById.get();
			
		}else
			throw new NoRecordFoundException(
					"Booking with BookingId: " + bookingId + " Not Present!!");
	}
	
	public List<Booking> viewAllBooking()
	{
	       List<Booking> list = bdao.findAll();
	       if(list.isEmpty()) {
	    	   throw new NoRecordFoundException("No Record Found To Show");
	       }
	       return list;
	}
	
	public String deleteBooking(long bookingId)
	{
		Optional<Booking> findById = bdao.findById(bookingId);
		if(findById.isPresent()) {
				bdao.deleteById(bookingId);
				return "Deletion Success with id - " +bookingId;
		}else {
			throw new NoRecordFoundException("No Record Found with id - "+ bookingId +" To Delete");
		}
	}
	


	
	
	

//	public void validateBooking(Booking booking)
//	{
//			int nop = booking.getNoOfPassengers();
//			int availableSeats = scheduledFlightDao.findById(booking.getFlight().getSfid()).get().getAvailableSeats();
//			
//			//no of passengers should be less than available seats
//			if(nop > availableSeats || nop<1 || nop!=booking.getPassengerList().size())
//			{
//				throw new InvalidBookingException("Number of passengers are invalid");
//			}
//			
//			//scheduled flight has to be there in database
//			List<ScheduledFlight> sflist = scheduledFlightDao.findAll();
//			if(sflist.stream().noneMatch(sf -> sf.getSfid().equals(booking.getFlight().getSfid()))) 
//			{
//				throw new InvalidBookingException("No flight scheduled for id "+booking.getFlight().getSfid());
//			}
//			
//			//arrival & departure date time > current date time 
//			if(booking.getFlight().getSchedule().getArrivalTime().compareTo(LocalDateTime.now()) 
//					|| booking.getFlight().getSchedule().getDepartureTime().compareTo(LocalDateTime.now()))
//			{
//				throw new InvalidBookingException("Arr and Dep Date&time are not valid(must be greater than LocalDateTime)");
//			}
//			
//			//Destination & source airport should be there in the database
//			List<Airport> a1 = airportDao.findAll();
//			if(a1.stream().noneMatch(a -> a.getAirportCode().equals(booking.getFlight().getSchedule().getSourceAirport().getAirportCode())) || 
//			a1.stream().noneMatch(a -> a.getAirportCode().equals(booking.getFlight().getSchedule().getDestinationAirport().getAirportCode())))
//			{
//				throw new InvalidBookingException("Airport does not exist");
//			}
//			
//			//Destination & source airport should be different
//			if (booking.getFlight().getSchedule().getDestinationAirport().getAirportCode().equals(booking.getFlight().getSchedule().getSourceAirport().getAirportCode())) 
//			{
//				throw new InvalidBookingException("Destination airport should not be same as Source airport");
//			}
//			
//			//Validate each passenger in the passenger list
//			for(Passenger p:booking.getPassengerList())
//			{
//				validatePassenger(p);
//			}
//	}
	
	
	
	
	
	
	public void validatePassenger(Passenger passenger) {
		//UIN should be of 12 digits
		Long UIN = passenger.getPassengerUIN();
		Pattern p= Pattern.compile("^[1-9][0-9]{11}$");
		Matcher m=p.matcher(UIN.toString());
	    //Matcher m=p.matcher(String.valueOf(UIN));
		if(!m.find())
		{
			throw new InvalidBookingException("Passenger UIN is invalid");
		}
	}
	
}

