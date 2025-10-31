package com.src.algo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter{
	
	AtomicInteger currentCapacity;
	AtomicLong lastUpdatedTime;
	private final int refreshRate;
	private final int bucketCapacity;
	
	
	public TokenBucket(int capacity, int refreshRate) {
		this.currentCapacity = new AtomicInteger(capacity);
		this.lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
		this.refreshRate = refreshRate;
		this.bucketCapacity = capacity;
			
	}
	
	@Override
	public boolean grantAccess() {
		
		if(currentCapacity.get()>0) {
			refreshBucket();
			currentCapacity.decrementAndGet();
			
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			return true;
		}
		return false;
	}
	
	private void refreshBucket() {
		long currentTime = System.currentTimeMillis();
		long lapsedTime = currentTime - lastUpdatedTime.get();
		
		int additionalToken = (int)(lapsedTime/1000*refreshRate);
		System.out.println(" "+lapsedTime+" "+additionalToken);
		if(additionalToken==0)
			return;
//		System.out.println(" "+lapsedTime+" "+additionalToken);
		int capacity = Math.min(currentCapacity.get()+additionalToken,bucketCapacity);
		currentCapacity.set(capacity);
		lastUpdatedTime.set(currentTime);
		
	}
	
	

}
