package com;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCreation {

	public static void main(String[] args) {
		
		//This method will create fixed number of threads
		ExecutorService service = Executors.newFixedThreadPool(3);

		//When we go with newCachedThreadPool JVM will create Thread according to requirement.If it is needed then it will find is there any thread free else it will create new Thread accordingly
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
		//It create ThreadPool that can schedule command to run after a given delay,or to execute periodically.We need to pass corePoolSize.corePoolSize the number of threads to keep in the pool.
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
		newScheduledThreadPool.schedule(new RunnableClass(), 1, TimeUnit.MINUTES);
		
		//It will create SingleTread for execution.If in case thread get terminated,new thread will be created for execution of the given task.It will execute task one at a time.
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		
		service.submit(new RunnableClass());
		
	}
	
}
