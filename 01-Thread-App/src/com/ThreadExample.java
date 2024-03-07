package com;

public class ThreadExample extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Run method called...");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		ThreadExample te=new ThreadExample();
		te.start();
		
		ThreadExample te1=new ThreadExample();
		te1.start();
		
		ThreadExample te2=new ThreadExample();
		te2.start();
		
	}
	
}
