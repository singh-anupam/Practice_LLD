package com.booking.main;

import com.booking.enums.DriverStatus;
import com.booking.enums.Rating;
import com.booking.manager.DriverManager;
import com.booking.manager.RiderManager;
import com.booking.manager.TripManager;
import com.booking.model.Driver;
import com.booking.model.Location;
import com.booking.model.Rider;
import com.booking.model.Trip;

public class Uber {
	
	public static void main(String args[]) {
		RiderManager riderManegr = RiderManager.getInstance();
		DriverManager driverManager = DriverManager.getInstance();
		
		TripManager tripManager = TripManager.getInstance();
		 Rider rider1 =new Rider("1","Archit",Rating.Good);
		 Rider rider2 =new Rider("2","Arpan",Rating.Avg);
		 Rider rider3 =new Rider("3","Abhinav",Rating.Bad);

		 
		riderManegr.addRider("1", rider1);
		riderManegr.addRider("2", rider2);
		riderManegr.addRider("3", rider3);
		
		driverManager.createDriver("101", new Driver("KunwarPal","101",Rating.Good,DriverStatus.Available));
		driverManager.createDriver("102", new Driver("Abcd","102",Rating.Avg,DriverStatus.Away));
		driverManager.createDriver("103", new Driver("Defg","103",Rating.Bad,DriverStatus.Driving));
		
		Trip trip = tripManager.createTrip(rider1, new Location(10,10,"Ddn"),new Location(100,100,"Blr"));
		Trip trip2 = tripManager.createTrip(rider3, new Location(10,10,"Ddn"),new Location(1156,1230,"Blr"));
		
		System.out.println(trip2.getPrice()+" "+trip2.getDriver().getName()+" "+trip2.getRider().getName());
		
		
	}

}
