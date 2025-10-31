package com.src.algo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter{
	
	
	private final int bucketCapacity;
	private final int windowSize;
	private Queue<Long> queue;
	
	public  SlidingWindow(int capacity, int windowSize) {
		this.bucketCapacity = capacity;
		this.windowSize = windowSize;
		queue = new ConcurrentLinkedQueue<>();
	}

	@Override
	public boolean grantAccess() {
		// TODO Auto-generated method stub
		long currentTime = System.currentTimeMillis();
		checkAndUpdateQueue(currentTime);
		if(queue.size()<bucketCapacity){
			queue.offer(currentTime);
			return true;
		}
		
		return false;
	}
	
	private void checkAndUpdateQueue(long currentTime) {
		if(queue.isEmpty())
			return ;
		long lastUpdatedTime = queue.peek();
		
		int lapsedTime = (int)(currentTime-lastUpdatedTime)/1000;
		
		while(queue.size()>0 && lapsedTime>windowSize) {
			queue.poll();
			if(queue.size()==0)
				return ;
			lapsedTime = (int)(currentTime - queue.peek())/1000;
		}
	}

}
