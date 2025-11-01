package com.mq.model;

import java.util.UUID;

import com.mq.subscriber.ISubscriber;

public class Subscriber implements ISubscriber{
	
	private String name;
	private int sleepTime;
	private String id;
	
	public Subscriber(String name, int sleepTime) {
	this.name = name;
	this.sleepTime = sleepTime;
	this.id = UUID.randomUUID().toString();
	}
	
	public void consumeMessage(Message message) {
		System.out.println("Message Consumption start for consumer id "+id+" "+message.getMessage());
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Message consumed id "+id);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	

}
