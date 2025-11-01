package com.booking.model;

import com.booking.enums.TripStatus;
import com.booking.strategy.DriverMatchingStrategy;
import com.booking.strategy.PricingStrategy;

public class Trip {
	
	private Driver driver;
	private Rider rider;
	private String tripId;
	private TripStatus tripStatus;
	private Location srcLocation;
	private Location destLocation;
	private double price;
	private DriverMatchingStrategy dStrategy;
	private PricingStrategy pStrategy;
	
	
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trip(Driver driver, Rider rider, TripStatus tripStatus, Location srcLocation,
			Location destLocation, double price) {
		super();
		this.driver = driver;
		this.rider = rider;
		this.tripStatus = tripStatus;
		this.srcLocation = srcLocation;
		this.destLocation = destLocation;
		this.price = price;
	
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public String getTripId() {
		return tripId;
	}
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	public TripStatus getTripStatus() {
		return tripStatus;
	}
	public void setTripStatus(TripStatus tripStatus) {
		this.tripStatus = tripStatus;
	}
	public Location getSrcLocation() {
		return srcLocation;
	}
	public void setSrcLocation(Location srcLocation) {
		this.srcLocation = srcLocation;
	}
	public Location getDestLocation() {
		return destLocation;
	}
	public void setDestLocation(Location destLocation) {
		this.destLocation = destLocation;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public DriverMatchingStrategy getdStrategy() {
		return dStrategy;
	}
	public void setdStrategy(DriverMatchingStrategy dStrategy) {
		this.dStrategy = dStrategy;
	}
	public PricingStrategy getpStrategy() {
		return pStrategy;
	}
	public void setpStrategy(PricingStrategy pStrategy) {
		this.pStrategy = pStrategy;
	}
	
	
	
	

}
