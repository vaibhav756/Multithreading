package com;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread{
	
	LinkedBlockingQueue<Integer> lq=null;
	
	public Consumer(LinkedBlockingQueue<Integer> lq) {
		this.lq=lq;
	}
	
	@Override
	public void run() {
		System.out.println("Consumer run method executed.");
		
		for(int i=0;i<7;i++)
		{
			try
			{
				Integer j = lq.take();
				System.out.println(j);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
