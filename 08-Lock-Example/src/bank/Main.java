package bank;

public class Main {

	public static void main(String[] args) {
		
		SBI vaibhav=new SBI(1000.00);
		
		new Thread(new GPay(vaibhav)).start();
		
		new Thread(new PhonePay(vaibhav)).start();
		
		new Thread(new UPI(vaibhav)).start();
		
		new Thread(new ATM(vaibhav)).start();
		
		
	}

}
