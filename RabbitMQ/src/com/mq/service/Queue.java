package com.mq.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.mq.model.Message;
import com.mq.model.Topic;
import com.mq.model.TopicHandler;
import com.mq.model.TopicSubscriber;
import com.mq.subscriber.ISubscriber;

public class Queue {
	
	Map<String,TopicHandler> map;
	
	public Queue() {
		map = new HashMap<>();
	}
	
	public Topic addTopic(String name, String id) {
		
		Topic topic = new Topic(name,id);
		TopicHandler topicHandler = new TopicHandler(topic);
		map.put(id,topicHandler);
		return topic;
		
	}
	
	public void pushMessage(Topic topic, Message message) {
		topic.addMessage(message);
		new Thread(()->map.get(topic.getTopicId()).handleMessage()).start();
		
	}
	
	public void addSubscriber(Topic topic, ISubscriber subscriber) {
		TopicSubscriber topicSubscriber = new TopicSubscriber(new AtomicInteger(0),subscriber);
		topic.addSubscriber(topicSubscriber);
		
	}
	
	public void resetOffset(Topic topic, ISubscriber sub, int offset) {
		
		for(TopicSubscriber sb : topic.getTopicSubscribers()) {
			if(sb.getSubscriber().equals(sub)) {
				sb.getOffset().set(offset);
				new Thread(()->map.get(topic.getTopicId()).work(sb)).start();
				break;
				
			}
		}
		
		
		
	}

}
