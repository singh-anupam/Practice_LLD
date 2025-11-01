package com.booking.strategy;

import com.booking.model.TripMetaData;

public interface PricingStrategy {
	
	public double getPrice(TripMetaData tripMetadat);

}
