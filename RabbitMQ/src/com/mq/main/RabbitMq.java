package com.mq.main;

import com.mq.model.Message;
import com.mq.model.Subscriber;
import com.mq.model.Topic;
import com.mq.service.Queue;
import com.mq.subscriber.ISubscriber;

public class RabbitMq {
	
	public static void main(String args[]) throws InterruptedException {
		Queue que = new Queue();
		Topic topic1 = que.addTopic("Topic-1","1");
		Topic topic2 = que.addTopic("Topic-2","2");
		Topic topic3 = que.addTopic("Topic-3","3");
		
		ISubscriber sub1 = new Subscriber("1-1",2000);
		ISubscriber sub2 = new Subscriber("2-2",2000);

		ISubscriber sub3 = new Subscriber("3-1",1000);

		ISubscriber sub4 = new Subscriber("4-3",2000);

		ISubscriber sub5 = new Subscriber("5-1",1000);
		
		que.addSubscriber(topic1, sub1);
		que.addSubscriber(topic1, sub3);
		que.addSubscriber(topic1, sub5);
		que.addSubscriber(topic2, sub2);
		que.addSubscriber(topic3, sub4);
		
		que.pushMessage(topic1, new Message("Hello i am Anupam"));
		que.pushMessage(topic1, new Message("Hello i am Archit"));
		que.pushMessage(topic2, new Message("Coding is fun"));
		que.pushMessage(topic3, new Message("Sometimes it is not"));
		
		Thread.sleep(10000);
		
		que.resetOffset(topic1, sub1, 0);
		
		que.pushMessage(topic1, new Message("Hello i am Abhinav"));
		
		System.out.println("Thread ended "+Thread.currentThread().getName());

	}

}
