package com.booking.manager;

import com.booking.model.TripMetaData;
import com.booking.strategy.DefaultPricingStrategy;
import com.booking.strategy.DriverMatchingStrategy;
import com.booking.strategy.PricingStrategy;
import com.booking.strategy.RatingBasedDriverStrategy;

public class StrategyManager {
	
	private static StrategyManager strategyManager;
	
	private StrategyManager() {
		
	}
	
	public static StrategyManager getInstance() {
		if(strategyManager==null) {
			synchronized(StrategyManager.class) {
				if(strategyManager==null) {
					strategyManager = new StrategyManager();
				}
			}
		}
		return strategyManager;
		
	}

	
	public PricingStrategy getPricingStrategy(TripMetaData tripMetaData) {
		return new DefaultPricingStrategy();
		
	}
	
	public DriverMatchingStrategy getDriverMatchingStrategy(TripMetaData tripMetaData) {
		return new RatingBasedDriverStrategy();
		
	}

}
