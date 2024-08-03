package com;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMainClass {

	public static void main(String[] args) {
		//Select * from Employee
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
		
		//Sequencial processing
		/*SalaryCalculation calculator=new SalaryCalculation();
		for(int i=0;i<list.size();i++)
		{
			calculator.calculateSalary(list.get(i));
		}*/
		
		//Parallel processing
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		System.out.println("LocalDateTime : "+LocalDateTime.now());
		for(Employee emp:list)
		{
			newFixedThreadPool.submit(new SalaryCalculation(emp));
		}
		System.out.println("LocalDateTime : "+LocalDateTime.now());
		//To terminate Threads we go with shutdown() method.If we don't kill Thread then will remain running all the time until we close program. 
		newFixedThreadPool.shutdown();
		System.out.println("------------------------------------------");
		/*ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for(Employee emp:list)
		{
			newCachedThreadPool.submit(new SalaryCalculation(emp));
		}
		newCachedThreadPool.shutdown();
		//Using CachedThreadPool concept
		/*for(int i=0;i<100000;i++)
		{
			newCachedThreadPool.submit(new NumberPrinting(i));
		}*/
		
		
	}
	
}
