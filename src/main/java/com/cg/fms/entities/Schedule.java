package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Schedule {
	
	@Id
	@GeneratedValue
	long sid;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	Airport sourceAirport;
	String sourceAirport;		

	
//	@OneToOne(cascade=CascadeType.ALL)
//	Airport destinationAirport;
	String destinationAirport;		
	
	
	//specify how to format datetime acc to SimpleDateTime format

//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
//	@ApiModelProperty(required = true, example = "2021-08-20 00:00:00")
	@Column(name="atime")
	String arrivalTime;
	
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
//	@ApiModelProperty(required = true, example = "2021-08-20 00:00:00")
	@Column(name="dtime")
	String departureTime;


	
}


	//Parameterized Constructor
//	public Schedule(BigInteger sid, Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,LocalDateTime departureTime) {
//		this.sid = sid;
//		this.sourceAirport = sourceAirport;
//		this.destinationAirport = destinationAirport;