package com.mq.model;

import java.util.concurrent.atomic.AtomicInteger;

import com.mq.subscriber.ISubscriber;

public class TopicSubscriber {
	
	private AtomicInteger offset;
	private ISubscriber subscriber;
	
	public TopicSubscriber(AtomicInteger offset, ISubscriber subscriber) {
		super();
		this.offset = offset;
		this.subscriber = subscriber;
	}
	public AtomicInteger getOffset() {
		return offset;
	}
	public void setOffset(AtomicInteger offset) {
		this.offset = offset;
	}
	public ISubscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(ISubscriber subscriber) {
		this.subscriber = subscriber;
	}
	

}
