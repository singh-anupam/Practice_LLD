package com.src.algo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucketCreator {

	Map<Integer,TokenBucket> userBucket;
	private final int bucketCapacity = 10;
	private final int refreshRate = 10;
	
	public UserBucketCreator(int id) {
		userBucket = new ConcurrentHashMap<>();		
		userBucket.put(id,new TokenBucket(bucketCapacity,refreshRate));
		
	}
	
	public void accessApi(int id) {
		if(userBucket.get(id).grantAccess()) {
			System.out.println(Thread.currentThread().getName()+" acess is granted for id "+id);
		}else {
			System.out.println(Thread.currentThread().getName()+" too many request for id "+id);
		}
		
	}
}
