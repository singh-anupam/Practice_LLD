package com.booking.manager;

import java.util.concurrent.atomic.AtomicInteger;

import com.booking.enums.TripStatus;
import com.booking.model.Driver;
import com.booking.model.Location;
import com.booking.model.Rider;
import com.booking.model.Trip;
import com.booking.model.TripMetaData;
import com.booking.strategy.DriverMatchingStrategy;
import com.booking.strategy.PricingStrategy;

public class TripManager {
	
	private static TripManager tripManager;
	private static AtomicInteger id;
	private TripManager() {
		
	}
	
	public static TripManager getInstance() {
		if(tripManager==null) {
			synchronized(TripManager.class){
				if(tripManager==null) {
					try {
						id = new AtomicInteger();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tripManager = new TripManager();
				}
			}
		}
		return tripManager;
		
	}
	
	public Trip createTrip(Rider rider, Location srcLocation, Location destLocation) {
		StrategyManager strategyManager = StrategyManager.getInstance();
		TripMetaData tripMetaData = new TripMetaData(srcLocation,destLocation,rider.getRating());
		
		PricingStrategy pricingStrategy = strategyManager.getPricingStrategy(tripMetaData);
		DriverMatchingStrategy driverStrategy = strategyManager.getDriverMatchingStrategy(tripMetaData);
		Driver driver = driverStrategy.getDriver(tripMetaData);
		double price = pricingStrategy.getPrice(tripMetaData);
		tripMetaData.setDriverRating(driver.getDriverRating());
		
		Trip trip = new Trip(driver,rider,TripStatus.InActive,srcLocation,destLocation,price);
		trip.setTripId(id.incrementAndGet()+"");
		
		return trip;
		
		
		
	}
	
	
}
