package com.mq.subscriber;

import com.mq.model.Message;

public interface ISubscriber {
	
	public String getId();
	
	public void consumeMessage(Message messgae);

}
