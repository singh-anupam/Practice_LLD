package com.booking.manager;

import java.util.HashMap;
import java.util.Map;

import com.booking.model.Rider;

public class RiderManager {
	
	private static final RiderManager riderManager = new RiderManager();
	
	Map<String,Rider> riderMap = new HashMap<>();
	
	private RiderManager() {
		
	}
	
	public static RiderManager getInstance() {
		return riderManager;
	}
	
	
	public boolean addRider(String id, Rider rider) {
		
		riderMap.put(id,rider);
		return true;
		
	}
	
	public Rider getRider(String id) {
		return riderMap.get(id);
	}

}
