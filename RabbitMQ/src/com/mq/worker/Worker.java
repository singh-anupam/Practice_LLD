package com.mq.worker;

import com.mq.model.Message;
import com.mq.model.Topic;
import com.mq.model.TopicSubscriber;

public class Worker implements Runnable{
	
	private Topic topic;
	TopicSubscriber topicSubscriber;
	
	public Worker(Topic topic, TopicSubscriber topicSubscriber) {
		this.topic = topic;
		this.topicSubscriber = topicSubscriber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			synchronized (topicSubscriber) {
				int currentOffset = topicSubscriber.getOffset().get();
				while (topic.getMessages().size() <= currentOffset) {
					try {
						topicSubscriber.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Message message = topic.getMessages().get(currentOffset);
				topicSubscriber.getSubscriber().consumeMessage(message);
				topicSubscriber.getOffset().compareAndSet(currentOffset, currentOffset+1);
			}
		} while (true);

	}
	
	public synchronized void wakeUpIfNeeded() {
		synchronized(topicSubscriber) {
		topicSubscriber.notify();
		}
	}

}
