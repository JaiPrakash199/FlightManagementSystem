package com.cg.fms.services;


import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.AirportCodeNotFoundException;
import com.cg.fms.exceptions.NoAirportsFoundException;

public interface AirportService{
	
	
	
	public Iterable<Airport> viewAllAirport() throws NoAirportsFoundException;

	public Airport viewAirportByCode(String airportCode) throws AirportCodeNotFoundException;

}
















	
	
	
//	 	public String addAirport(Airport airport) throws RecordAlreadyPresentException;
//	
//	//view all airport
//		public Iterable<Airport> viewAllAirport() throws NoAirportsFoundException;
//		
//		public Airport viewAirportByCode(String code) throws AirportCodeNotFoundException;

		//public Airport viewAirportByName(String airportName) throws AirportNameNotFoundException;
		
		//public Airport viewAirportByName (String name) throws AirportNameNotFoundException;
		
	



