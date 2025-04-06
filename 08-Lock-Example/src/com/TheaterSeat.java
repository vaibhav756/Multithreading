package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TheaterSeat {

	private Integer seatNo;
	Lock lock=new ReentrantLock(true);
	public TheaterSeat(Integer seatNo) {
		super();
		this.seatNo = seatNo;
	}

	public void setSeatNo(Integer seatNo)
	{
		this.seatNo=seatNo;
	}
	
	public Integer getSeatNo()
	{
		return seatNo;
	}
	
	public void bookTicket(Integer seatno)
	{
		//If there is no lock acquire lock
		if(lock.tryLock())
		{
			System.out.println(seatno+" Seat Booked successfully by "+Thread.currentThread().getName()+".");
		}
		//If there is lock do something else
		else
		{
			System.out.println("Seat has been booked.");
		}
	}
	
}
