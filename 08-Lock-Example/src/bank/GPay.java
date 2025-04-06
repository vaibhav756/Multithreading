package bank;

public class GPay implements Runnable{

	SBI user;
	
	public GPay(SBI user) {
		this.user=user;
	}
	
	@Override
	public void run() {
		user.bookTicket(2000.00);
	}
	
}
