package com.booking.strategy;

import java.util.Map;

import com.booking.manager.DriverManager;
import com.booking.model.Driver;
import com.booking.model.TripMetaData;

public class RatingBasedDriverStrategy implements DriverMatchingStrategy {

	
	private DriverManager driverManager;
	@Override
	public Driver getDriver(TripMetaData tripMetaData) {
		
		driverManager = DriverManager.getInstance();
		Map<String,Driver> map = driverManager.getDriverMap();
		for(String key :  map.keySet()) {
			Driver driver = map.get(key);
			if(driver.getDriverRating().equals(tripMetaData.getRiderRating()))
				return driver;
		}
		// TODO Auto-generated method stub
		return map.get(0);
	}

}
