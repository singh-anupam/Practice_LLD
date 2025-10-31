package com.src.algo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterApplication {


	public static void main(String[] args) {
		
		UserBucketCreator userBucketCreator = new UserBucketCreator(1);
		ExecutorService exService  = Executors.newFixedThreadPool(10);
		for(int i=0;i<12;i++) {
			exService.execute(()->userBucketCreator.accessApi(1));
		}

	}

}
