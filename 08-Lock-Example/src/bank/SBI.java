package bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SBI {

	private Double balance;
	
	//When Thread holds lock on synchronization method of an object, other threads which want this object should go in waiting mode until current thread release lock.
	//1.Once current thread release lock any one of waiting thread will get chance to execute.JVM doesn't check which thread is waiting for longer period of time.This problem is solved with Lock Interface.
	//2.When we go with synchronized keyword,lock is acquired within method.If we want to acquire lock in one method and release in another method is not possible.
	//Lock Interface is an alternate way for synchronization with mutual understanding execution.It provides more flexibility and control over the locking behavior than synchronization.
	//Lock interface is a part of java.util.concurrent package.It provides some methods to acquire and release the lock.
	//***Acquiring lock among methods in possible in lock interface.(Acquiring lock in 1 method and releasing in another method.)
	Lock lock=new ReentrantLock(true);
	Condition con=lock.newCondition();
	
	public SBI(Double balance) {
		super();
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void deposite(Double balance)
	{
		lock.lock();
		this.balance+=balance;
		con.signalAll();
		lock.unlock();
	}
	
	public void withdraw(Double balance)
	{
		//Acquiring lock in method and releasing in another method is possible in lock interface.
		lock.lock();
		if(this.balance<balance)
		{
			try {
				con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.balance-=balance;
		System.out.println("Amount withdraw : "+balance+", Remaining Balance : "+this.balance);
		//Always write unlock() method in finally block.
		lock.unlock();
	}
	
	public void bookTicket(Double val)
	{
		lock.lock();
		if(this.balance<val)
		{
			try {
				con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.balance-=val;
			System.out.println("Ticket booked for "+val+", Remaining Balance : "+balance);
		}
		lock.unlock();
	}
	
	public void payElecticityBill(Double bill)
	{
		lock.lock();
		if(this.balance<bill)
		{
			try {
				con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.balance-=bill;
		}
		System.out.println("Bill Paid : "+bill+", Remaining Balance : "+balance);
		lock.unlock();
	}
	
	//Acquiring lock in one method and releasing in another method.
	/*public void m1()
	{
		lock.lock();
		try
		{
			m2();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void m2()
	{
		//Perform operation
		lock.unlock();
	}*/
	
}
