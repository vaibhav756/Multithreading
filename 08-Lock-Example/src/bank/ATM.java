package bank;

public class ATM implements Runnable{

	SBI user;
	
	public ATM(SBI user) {
		this.user=user;
	}
	
	@Override
	public void run() {
		user.deposite(10000.00);
	}
	
}
