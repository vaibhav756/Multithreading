package com;

public class HDFCBank {

	Double balance;
	
	public HDFCBank(Double balance) {
		this.balance=balance;
	}
	
	//wait() method allow other threads for execution on same object whereas sleep() method doesn't allow other thread for execution
	//wait() method release lock whereas sleep() method doesn't release lock.
	public synchronized void withdraw(Double bal)throws Exception
	{
		if(bal<balance)
		this.balance=this.balance-bal;
		else
		//Thread.sleep(10000);
		wait();
	}
	
	//When 100 Threads are waiting for execution on same object and we call notify() method then JVM will allow any 1 thread for execution and we don't know which thread will get the chance for execution
	//When 100 Threads are waiting for execution on same object and we call notifyAll() method then JVM will allow all the threads for execution one by one.
	//notifyAll() method doesn't allow other objects for execution.It will only it's own object thread for execution not any other object.
	public synchronized void deposite(Double bal)
	{
		this.balance=this.balance+bal;
		notifyAll();
	}
	
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
