package com;

public class GPay extends Thread{

	HDFCBank bnk;
	
	public GPay(HDFCBank bnk)
	{
		this.bnk=bnk;
	}
	
	@Override
	public void run() {
		System.out.println("GPay thread...");
		bnk.nonsynchronizedmethod();
		bnk.printusername();
		bnk.deposite(8000.00);
	}
	
}
