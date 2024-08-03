package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolCreationWithCallable {

	public static void main(String[] args){
		
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
		System.out.println("Thread Pool creation using FixedThreadPool.");
		//In FixedTreadPool we need to pass how many number of threads we have to create.If all threads are busy then Object will go in LinkedBlockingQueue and when thread become free it will pick next object for execution.
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i=0;i<list.size();i++)
		{
			Future<Employee> emp = newFixedThreadPool.submit(new SalaryCalculationWithCallable(list.get(i)));
			try
			{
				//Future.get() method throws InterrupedException && ExecutionException if we try to get() object before execution.
				//To overcome this problem we have .isDone() method.
				//This method doesn't give proper result if our main thread is running before other threads.
				//We have second option to overcome this problem called 'CountDownLatch'.
				//To run thread one after other we need to go with .join() method but it doesn't work with Executor framework for that we are going with 'CountDownLatch'.
				if(emp.isDone())
				{
					System.out.println(emp.get().empName+"'s salary "+emp.get().salary);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//If we don't shutdown the thread's then it will be in running state for all the time.In FixedThreadPool we need to shutdown all threads manually.
		//Sometimes .shutdown() method executes earlier which gives wrong result.Therefore always better to go with newCachedThreadPool();
		newFixedThreadPool.shutdown();
		System.out.println("Check Thread Pool and Threads.");
	}
	
}
