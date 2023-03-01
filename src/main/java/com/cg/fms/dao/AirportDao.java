package com.cg.fms.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.Airport;

public interface AirportDao extends JpaRepository<Airport, String>{

}
