package com.booking.strategy;

import com.booking.model.Driver;
import com.booking.model.TripMetaData;

public interface DriverMatchingStrategy {
	
	public Driver getDriver(TripMetaData tripMetaData);

}
