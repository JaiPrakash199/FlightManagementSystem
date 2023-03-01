package com.cg.fms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.AirportDao;
import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.AirportCodeNotFoundException;
import com.cg.fms.exceptions.NoAirportsFoundException;

@Service("airportService")
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportDao airportDao;
	
	
	
	@Override
	public Iterable<Airport> viewAllAirport() {
		Iterable<Airport> alist = airportDao.findAll();
		if(alist == null) {
			throw new NoAirportsFoundException("No Aiport found");
		}
		return alist;
	}
	@Override
	public Airport viewAirportByCode(String airportCode) {
		java.util.Optional<Airport> opId = airportDao.findById(airportCode);
		if (opId.isPresent()) {
			return opId.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new AirportCodeNotFoundException("Airport with airport code: " + airportCode + "not exists");
	    }
	
	
	
	
		
	//@Override
//	public String addAirport(Airport airport) {
////		
//		Airport air = airportDao.save(airport);
//		return "Added" + air.getAirportCode();
//	}
	
	
	
	
	
	
	
	
	
	
	//java.util.Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
//	try {
//	if (!findById.isPresent()) {
//		airportDao.save(airport);
//		return new ResponseEntity<Airport>(airport,HttpStatus.OK);
//	} 
//	else
//		throw new RecordAlreadyPresentException(
//				"Airport with code : " + airport.getAirportCode() + " already present");
//     }
//	catch(RecordAlreadyPresentException e)
//	{
//		return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
//	}
	
	
	
//	@Override
//	public ResponseEntity<?> addAirport(Airport airport) throws RecordAlreadyPresentException {
//		java.util.Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
//		
//		if (!findById.isPresent()) {
//			airportDao.save(airport);
//			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
//		} 
//		else
//			throw new RecordAlreadyPresentException(
//					"Airport with code : " + airport.getAirportCode() + " already present");
//	     
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public String addAirport(Airport airport)  {
//		//java.util.Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
//		Airport air = airportDao.save(airport);
//		return "Added Airport"+ air.getAid();
////		if (!findById.isPresent()) {
////			airportDao.save(airport);
////			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
////			}else
////			throw new RecordAlreadyPresentException("Airport with code : " + airport.getAirportCode() + " already present");
//	     }
////		catch(RecordAlreadyPresentException e)
////		{
////			return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
////		}
//	
//
//	
//	public Iterable<Airport> viewAllAirport() throws NoAirportsFoundException {
//		{
//			Iterable<Airport> alist = airportDao.findAll();
//			if(alist==null) {
//				throw new NoAirportsFoundException("No Airports found");
//			}
//
//		}
//		return airportDao.findAll();
//	}
//
//	public Airport viewAirportByCode(String code) throws AirportCodeNotFoundException {
//		// Optional<Airport> a = ad.findById(code);
//		java.util.Optional<Airport> findById = airportDao.findById(code);
//
//		if (findById.isPresent()) {
//			return findById.get();
//		} else {
//			throw new AirportCodeNotFoundException("No airport found with code " + code);
//		}

	}
//	public Airport viewAirportByName (String name) throws AirportNameNotFoundException 
//	{
//		java.util.Optional<Airport> findByName = airportDao.findByName(name);
//		if(findByName.isPresent()) {
//			return findByName.get();
//		}
//		else {
//			throw new AirportNameNotFoundException("No airport found with name" + name);
//		}
//	}

	
	



 
//	@Override
//	public Airport modifyAirport(Airport airport) throws RecordNotFoundException {
//		java.util.Optional<Airport> findById = airportDao.findById(airport.getAirportCode());
//		if (findById.isPresent()) {
//			airportDao.save(airport);
//		} 
//		else
//			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
//		return airport;
//	}
//	public String removeAirport(String airportCode) throws RecordNotFoundException {
//		java.util.Optional<Airport> findById = airportDao.findById(airportCode);
//		if (findById.isPresent()) {
//			airportDao.deleteById(airportCode);
//			return "Airport removed";
//		} else
//			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");
//
//	}
