package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	public static void main(String[] args) {
		
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(101,"Vaibhav",100.00,25));
		list.add(new Employee(102,"Rohan",200.00,28));
		list.add(new Employee(103,"Ketan",150.00,20));
		list.add(new Employee(104,"Amar",120.00,22));
		list.add(new Employee(105,"Kiran",70.00,26));
		list.add(new Employee(106,"Tejas",130.00,27));
		list.add(new Employee(107,"Rohit",200.00,30));
		list.add(new Employee(108,"Piyush",250.00,28));
		list.add(new Employee(109,"Amol",220.00,25));
		list.add(new Employee(110,"Mohit",290.00,25));
		System.out.println("Thread Pool creation using CachedThreadPool.");
		//In ScheduledThreadPool we need to mention how many threads we want to create.As name mentioned this threads run after particular time period.
		//In ScheduledThreadPool we need to use schedule(Runnable,Delay,TimeUnit) method for execution.In this method we need to mention timeperiod for execution.
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
		for(int i=0;i<list.size();i++)
		{
			newScheduledThreadPool.schedule(new SalaryCalculation(list.get(i)),1, TimeUnit.MINUTES);
		}
		//If we don't shutdown the thread's then it will be in running state for all the time.In ScheduledThreadPool we need to shutdown all threads manually.
		newScheduledThreadPool.shutdown();
		System.out.println("Check Thread Pool and Threads.");
	}
	
}
