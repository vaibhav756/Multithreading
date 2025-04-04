package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class MainClass {

	public static void main(String[] args) {

		//List of students matching with scheme criteria
		List<String> emails=new ArrayList<>();
		emails.add("Vaibhav");
		emails.add("Rohan");
		emails.add("Ketan");
		emails.add("Amit");
		emails.add("Aditya");
		
		ExecutorService es = Executors.newCachedThreadPool();
		List<Future> futurelist=new ArrayList<>();
		CountDownLatch cdl=new CountDownLatch(emails.size());
		Semaphore sema=new Semaphore(2);
		emails.forEach(email->{
			futurelist.add(es.submit(new SendEmail(email,cdl,sema)));
		});
		try {
			cdl.await();  //CountDownLatch.await() method will keep current Thread in waiting mode until all Threads are not done with it's execution.
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(Future future:futurelist)
		{
			if(future.isDone())
			{
				try {
					System.out.println(future.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		es.shutdown();
		
		
		
	}

}
