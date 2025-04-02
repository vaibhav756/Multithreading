package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	static CountDownLatch cdl=null;
	
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
		
		List<Future<Employee>> futurelist=new ArrayList<>();
		ExecutorService exservice = Executors.newCachedThreadPool();
		cdl=new CountDownLatch(list.size());
		for(int i=0;i<list.size();i++)
		{
			futurelist.add(exservice.submit(new SalaryCalculation(list.get(i),cdl)));
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	}
	
}
