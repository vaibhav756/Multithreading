package com;

public class HDFCBank {

	Double balance;
	
	public HDFCBank(Double balance) {
		this.balance=balance;
	}
	
	//Object Lock
	//Object lock is associated with instance method
	//Same object can't use synchronized methods on same class
	//If Objects are different then we can access any synchronized method
	public synchronized void withdraw(Double bal)
	{
		this.balance=this.balance-bal;
	}
	
	//Object Lock
	public synchronized void deposite(Double bal)
	{
		this.balance=this.balance+bal;
	}
	
	//Class Lock 
	//When we write synchronized keyword on static method it is called as 'Class Lock'
	//Even two different objects can't access this method simultaneously because we have acquired lock on class not on object
	public static synchronized void printusername()
	{
		System.out.println("Vaibhav Yadav "+Thread.currentThread().getName());
	}
	
	public void nonsynchronizedmethod()
	{
		System.out.println("nonsynchronizedmethod executed...");
	}
	
	public synchronized Double getBalance()
	{
		return this.balance;
	}
}
