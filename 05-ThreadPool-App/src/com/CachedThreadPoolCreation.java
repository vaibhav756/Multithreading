package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolCreation {

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
		//In CachedThreadPool threads are created as per requirement by JVM.if it is needed then it creates new thread else it will use previous created thread.
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for(int i=0;i<list.size();i++)
		{
			newCachedThreadPool.submit(new SalaryCalculation(list.get(i)));
		}
		//In CachedThreadPool shutingdown thread is done by JVM only we don't need to do this manually.
		//newCachedThreadPool.shutdown();
		System.out.println("Check Thread Pool and Threads.");
	}
	
}
