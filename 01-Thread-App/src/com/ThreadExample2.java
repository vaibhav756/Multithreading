package com;

public class ThreadExample2 extends Thread{

	public ThreadExample2()
	{
		super();
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getState());
		System.out.println("Runnable interface run method executed...");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getState());
		ThreadExample2 te=new ThreadExample2();
		te.start();
	}

}
