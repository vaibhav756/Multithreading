package com;

public class ThreadExampleWithRunnable implements Runnable{

    @Override
	public void run() {

    	System.out.println(Thread.currentThread().getName());
    	System.out.println("Runnable interface run method executed...");
	}	 
	
	public static void main(String[] args) {

		//ThreadExampleWithRunnable ex=new ThreadExampleWithRunnable();
		Thread t=new Thread(new ThreadExampleWithRunnable());
		t.start();
	}

}
