package com.mq.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
	
	private String name;
	private String topicId;
	private List<Message> messages;
	private List<TopicSubscriber> topicSubscribers;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<TopicSubscriber> getTopicSubscribers() {
		return topicSubscribers;
	}

	public void setTopicSubscribers(List<TopicSubscriber> topicSubscribers) {
		this.topicSubscribers = topicSubscribers;
	}

	public Topic(String name,String id) {
		this.name =  name;
		this.topicId = id;
		messages = new ArrayList<>();
		topicSubscribers = new ArrayList<>();
		
	}
	
	public synchronized void addMessage(Message message) {
		 messages.add(message);
	}
	
	public void addSubscriber(TopicSubscriber topicSubscriber) {
		topicSubscribers.add(topicSubscriber);
	}

}
