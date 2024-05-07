package com;

public class ATM extends Thread{

	HDFCBank bnk;
	
	public ATM(HDFCBank bnk)
	{
		this.bnk=bnk;
	}
	
	@Override
	public void run() {
		try {
			bnk.withdraw(15000.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
