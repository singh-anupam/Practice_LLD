package com.booking.model;

import com.booking.enums.DriverStatus;
import com.booking.enums.Rating;

public class Driver {
	private String name;
	private String id;
	private Rating driverRating;
	private DriverStatus status;
	
	public Driver(String name, String id, Rating driverRating, DriverStatus status) {
		super();
		this.name = name;
		this.id = id;
		this.driverRating = driverRating;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Rating getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(Rating driverRating) {
		this.driverRating = driverRating;
	}
	public DriverStatus getStatus() {
		return status;
	}
	public void setStatus(DriverStatus status) {
		this.status = status;
	}
	
	
}
