package com;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		HDFCBank vaibhav=new HDFCBank(10000.00);
		HDFCBank rohan=new HDFCBank(20000.00);
		ATM atm=new ATM(vaibhav);
		atm.setName("ATM Thread");
		atm.start();
		
		//Synchronization work on same object
		//If method is asynchronous thread won't wait for execution
		GPay pay=new GPay(vaibhav);
		pay.setName("GPAY");
		pay.start();
		
		//Synchronization only work on same object
		/*GPay pay=new GPay(rohan);
		pay.setName("GPAY");
		pay.start();*/
		
		Thread main = Thread.currentThread();
		main.sleep(1000);
		System.out.println(vaibhav.getBalance());
	}

}
