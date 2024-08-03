package com;

import java.util.concurrent.LinkedBlockingQueue;

public class MainClass {

	public static void main(String[] args) {
		LinkedBlockingQueue<Integer> lq=new LinkedBlockingQueue<>(5);
		//This class work with Consumer and Producer
		Producer p=new Producer(lq);
		Consumer c=new Consumer(lq);
		p.start();
		c.start();
		
	}

}
