package com;

public class MainApp {

	public static void main(String[] args) {
		HDFCBank vaibhav=new HDFCBank(5000.00);
		
		ATM withdraw=new ATM(vaibhav);
		withdraw.start();
		
		GPay vaibhavpay=new GPay(vaibhav);
		vaibhavpay.start();
		
		ATM withdraw1=new ATM(vaibhav);
		withdraw1.start();
		
	}

}
