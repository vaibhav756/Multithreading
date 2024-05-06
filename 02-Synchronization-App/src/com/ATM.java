package com;

public class ATM extends Thread{

	HDFCBank bnk;
	
	public ATM(HDFCBank bnk)
	{
		this.bnk=bnk;
	}
	
	@Override
	public void run() {
		System.out.println("ATM Thread...");
		bnk.printusername();
		bnk.withdraw(5000.00);
	}
	
	
	
}
