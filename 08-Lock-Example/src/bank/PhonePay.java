package bank;

public class PhonePay implements Runnable{

	SBI user;
	
	public PhonePay(SBI user)
	{
		this.user=user;
	}
	
	@Override
	public void run() {
		user.payElecticityBill(3000.00);
	}
	
}
