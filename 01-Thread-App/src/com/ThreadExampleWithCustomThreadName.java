package com;

public class ThreadExampleWithCustomThreadName extends Thread{

	public ThreadExampleWithCustomThreadName(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Run method executed...");
	}
	
	public static void main(String[] args) {

		ThreadExampleWithCustomThreadName ex=new ThreadExampleWithCustomThreadName("Vaibhav Thread");
		ex.start();
		ThreadExampleWithCustomThreadName ex1=new ThreadExampleWithCustomThreadName("Rohan Thread");
		ex1.start();
		
	}

}
