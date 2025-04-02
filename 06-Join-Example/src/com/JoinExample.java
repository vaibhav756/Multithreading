package com;

public class JoinExample {

	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		t1.setName("Salary calculation thread.");
		
		Thread2 t2=new Thread2();
		t2.setName("Salary transfering thread.");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
	}
	
}
