package com.booking.strategy;

import com.booking.model.TripMetaData;

public class DefaultPricingStrategy implements PricingStrategy {

	@Override
	public double getPrice(TripMetaData tripMetadat) {
		// TODO Auto-generated method stub
		
		return Math.abs(tripMetadat.getSrcLoaction().getX() - tripMetadat.getDestLocation().getX())*100;
	
	}

}
