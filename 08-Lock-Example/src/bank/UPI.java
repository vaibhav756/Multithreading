package bank;

public class UPI implements Runnable{

	SBI user;
	
	public UPI(SBI user) {
		this.user=user;
	}
	
	@Override
	public void run() {
		user.withdraw(3000.00);
	}
	
}
