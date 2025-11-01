package com.mq.model;

import java.util.HashMap;
import java.util.Map;

import com.mq.worker.Worker;

public class TopicHandler {
	
	private Topic topic;
	private Map<String,Worker> map;
	
	public TopicHandler(Topic topic){
		this.topic = topic;
		map = new HashMap<>();
		
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Map<String, Worker> getMap() {
		return map;
	}
	public void setMap(Map<String, Worker> map) {
		this.map = map;
	}
	
	public void handleMessage() {
		for(TopicSubscriber sub : topic.getTopicSubscribers()) {
			work(sub);
		}
	}
	
	public void work(TopicSubscriber sub) {
		if(!map.containsKey(sub.getSubscriber().getId())) {
			Worker worker = new Worker(topic,sub);
			map.put(sub.getSubscriber().getId(), worker);
			new Thread(worker).start();
		}else
			map.get(sub.getSubscriber().getId()).wakeUpIfNeeded();	
		
	}
	
	

}
