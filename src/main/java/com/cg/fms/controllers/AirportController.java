package com.cg.fms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Airport;
import com.cg.fms.exceptions.AirportCodeNotFoundException;
import com.cg.fms.exceptions.NoAirportsFoundException;
import com.cg.fms.services.AirportService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
//@RequestMapping("/airports")
public class AirportController {

	AirportService airportService;
	

	
	@Operation(summary = "Get all the airports")
	@GetMapping(value = "/airports")
	public ResponseEntity<Iterable<Airport>> viewAllAirport() throws NoAirportsFoundException {
		Iterable<Airport> list = airportService.viewAllAirport();
		ResponseEntity<Iterable<Airport>> rEntity = new ResponseEntity<Iterable<Airport>>(list, HttpStatus.FOUND);
		//return airportService.viewAllAirport();
		return rEntity;
	}
	
	@Operation(summary = "Get all the aiports Bycode")
	@GetMapping("/airports/viewAirportByCode/{airportCode}")
//	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Airport> viewAirportByCode(@PathVariable("airportCode") String airportCode) throws AirportCodeNotFoundException {
		Airport ar= airportService.viewAirportByCode(airportCode);
		ResponseEntity<Airport> rEntity = new ResponseEntity<Airport>(ar, HttpStatus.FOUND);
		return rEntity;
	}
	
}
	
	
	
	
	



//@Operation(summary = "Add the airport")
//@PostMapping(value = "/airports")
////@ExceptionHandler(RecordAlreadyPresentException.class)
//public ResponseEntity<String> addAirport(@Valid @RequestBody Airport airport) throws RecordAlreadyPresentException {
//	String a = airportService.addAirport(airport);
//	ResponseEntity<String> rEntity = new ResponseEntity<String>(a,HttpStatus.CREATED);
//	return rEntity;
//}

	
	
	
	
	
//	@Operation(summary = "Get all the aiports ByName")
//	@GetMapping("/viewAirport/{name}")
////@ExceptionHandler(RecordNotFoundException.class)
//	public ResponseEntity<Airport> viewAirportByName(@PathVariable("id") String airportName) throws AirportCodeNotFoundException, AirportNameNotFoundException {
//		Airport ar= airportService.viewAirportByName(airportName);
//		ResponseEntity<Airport> rEntity = new ResponseEntity<Airport>(ar, HttpStatus.FOUND);
//		return rEntity;
//		//return airportService.viewAirport(airportCode);
//	}


//		
//
//		@PutMapping(value = "/updateAirport")
//		@ExceptionHandler(RecordNotFoundException.class)
//		public void modifyAirport(@RequestBody Airport airport) {
//			airportService.modifyAirport(airport);
//		}
//
//		@DeleteMapping("/deleteAirport/{id}")
//		@ExceptionHandler(RecordNotFoundException.class)
//		public void removeAirport(@PathVariable("id") String airportCode) throws RecordNotFoundException {
//			airportService.removeAirport(airportCode);
//		}
/*
 * @PostMapping("/addAirport") public void addAirport(@RequestBody Airport
 * airport) throws RecordAlreadyPresentException {
 * airportService.addAirport(airport); }
 */
