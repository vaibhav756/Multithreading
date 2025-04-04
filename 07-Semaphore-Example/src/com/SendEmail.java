package com;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SendEmail implements Callable<Map<String,Boolean>>{

	String email;
	//Semaphore sema=new Semaphore(2); //Allow only 2 threads to access sendEmail method at a time.
	Semaphore sema;
	//Semaphore in java is a synchronization mechanism that allows a fixed number of threads to access shared resources at a time. 
	//Semaphore maintains state(count) for accesible threads.If count is greater than Zero it will allow Thread to access sendEmail method.
	//If count is zero it keeps Thread in waiting state.
	//Once working Thread is done with it's execution it releases the lock and waiting Thread get chance to execute.
	//Using Semaphore we restrict limited Threads to execute particular method which minimizes burdon on server.
	
	CountDownLatch cdl;
	//CountDownLatch is use to restrict caller method util all task's are done.
	//In ExecutorService we don't have support for .join method.So alternate to that we have CountDownLatch.
	//CountDownLatch doesn't allow main(Caller) Thread to execute further before completing this task.
	
	public SendEmail(String email,CountDownLatch cdl,Semaphore sema) {
		this.email=email;
		this.cdl=cdl;
		this.sema=sema;
	}
	
	@Override
	public Map<String,Boolean> call() throws Exception {
		
		sema.acquire(); //Acquire lock for accessing sendEmail method 
		Map<String,Boolean> result = sendEmail(email);
		cdl.countDown();
		sema.release(); //Release lock so that other thread can access sendEmail method.
		return result;
	}
	
	public Map<String,Boolean> sendEmail(String email)
	{
		//Send Email and return response
		Map<String,Boolean> result=new HashMap<>();
		result.put(email, true);
		return result;
	}
	
}