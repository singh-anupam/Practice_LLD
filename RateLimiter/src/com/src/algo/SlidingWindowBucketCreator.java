package com.src.algo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowBucketCreator {
	
	Map<Integer,SlidingWindow> map;
	private final int bucketCapacity = 10;
	private final int timeFrame=1;
	public SlidingWindowBucketCreator(int id) {
		map = new ConcurrentHashMap<>();
		map.put(id, new SlidingWindow(bucketCapacity,timeFrame));
	}
	
	
	public void accessApi(int id) {
		if(map.get(id).grantAccess()) {
			System.out.println("Acess granted for user id "+id);
		}else {
			System.out.println("Too many request from user id "+id);
		}
	}

}
