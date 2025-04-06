package com;

public class MainClass {

	public static void main(String[] args) {

		TheaterSeat s1=new TheaterSeat(101);
		
		Thread t1=new Thread(new BookMyShow(s1));
		t1.setName("Phone Pay");
		t1.start();
		Thread t2=new Thread(new BookMyShow(s1));
		t2.setName("GPay");
		t2.start();
		Thread t3=new Thread(new BookMyShow(s1));
		t3.setName("Bhim UPI");
		t3.start();
	}
	
}
