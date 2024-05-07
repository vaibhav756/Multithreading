package com;

public class HDFCBank {

	Double balance;
	
	public HDFCBank(Double balance) {
		this.balance=balance;
	}
	
	//sleep() method is static method and it is available in Thread class.
	//When we go with sleep() method it doesn't release lock on object to give access to another thread
	//wait() method is instance method and it is present in Object class
	//wait() method releases lock on object and allow other thread to access any synchronised method for that object 
	public synchronized void withdraw(Double bal)throws Exception
	{
		if(bal<balance)
		this.balance=this.balance-bal;
		else
		//Thread.sleep(10000);
		wait();
	}
	
	//Object Lock
	//notify()
	//When 100 Threads are waiting for execution on same object and we call notify() method then it will allow any 1 thread for execution and we don't know which thread will get the chance for execution
	public synchronized void deposite(Double bal)
	{
		this.balance=this.balance+bal;
		notify();
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
