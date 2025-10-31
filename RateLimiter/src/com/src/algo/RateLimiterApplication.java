package com.src.algo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterApplication {

	private static ExecutorService exService ;
	public static void main(String[] args) {
		
		UserBucketCreator userBucketCreator = new UserBucketCreator(1);
		exService = Executors.newFixedThreadPool(10);
		spawnThread(new SlidingWindowBucketCreator(1));
		

	}
	
	private static void spawnThread(UserBucketCreator userBucketCreator) {
		for(int i=0;i<12;i++) {
			exService.execute(()->userBucketCreator.accessApi(1));
		}
	}
	
	private static void spawnThread(SlidingWindowBucketCreator slidingWindowBucketCreator) {
		for(int i=0;i<15;i++) {
			exService.execute(()->slidingWindowBucketCreator.accessApi(1));
		}
	}

}
