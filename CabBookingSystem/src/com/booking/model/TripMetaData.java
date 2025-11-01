package com.booking.model;

import com.booking.enums.Rating;

public class TripMetaData {
	
	private Location srcLoaction;
	private Location destLocation;
	private Rating driverRating;
	private Rating riderRating;
	
	
	public Rating getRiderRating() {
		return riderRating;
	}
	public void setRiderRating(Rating riderRating) {
		this.riderRating = riderRating;
	}
	public TripMetaData(Location src, Location dest, Rating riderRating) {
		this.riderRating = riderRating;
		this.srcLoaction = src;
		this.destLocation = dest;
	}
	public Location getSrcLoaction() {
		return srcLoaction;
	}
	public void setSrcLoaction(Location srcLoaction) {
		this.srcLoaction = srcLoaction;
	}
	public Location getDestLocation() {
		return destLocation;
	}
	public void setDestLocation(Location destLocation) {
		this.destLocation = destLocation;
	}
	public Rating getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(Rating driverRating) {
		this.driverRating = driverRating;
	}
	

}
