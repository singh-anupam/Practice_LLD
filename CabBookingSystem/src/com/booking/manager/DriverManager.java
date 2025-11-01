package com.booking.manager;

import java.util.HashMap;
import java.util.Map;

import com.booking.enums.DriverStatus;
import com.booking.model.Driver;

public class DriverManager {
	
	private static DriverManager driverManager;
	private Map<String,Driver> driverMap=new HashMap<>();
	
	public  Map<String,Driver> getDriverMap() {
		return driverMap;
	}
	
	private DriverManager() {
		
	}
	
	public static DriverManager getInstance() {
		if(driverManager==null) {
			synchronized(DriverManager.class) {
				if(driverManager==null) {
					driverManager = new DriverManager();
				}
			}
		}
		
		return driverManager;
	}
	
	public boolean createDriver(String id, Driver driver) {
		if(driverMap.containsKey(id))
			return false;
		driverMap.put(id,driver);
		return true;
		
	}
	
	public boolean updateDriverStatus(String driverId, DriverStatus status) {
		for(Map.Entry<String, Driver> entry : driverMap.entrySet()) {
			if(entry.getKey().equals(driverId))
				{
				entry.getValue().setStatus(status);
				return true;
				}
			
		}
		return false;
	}
	
	

}
