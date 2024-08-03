package com;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread{

	LinkedBlockingQueue<Integer> lq=null;
	
	public Producer(LinkedBlockingQueue<Integer> lq) {
		this.lq=lq;
	}
	
	@Override
	public void run() {
		System.out.println("Producer run method executed.");
		
		for(int i=0;i<7;i++)
		{
			try
			{
				lq.put(i);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
}
