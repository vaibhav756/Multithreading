package com;

public class BookMyShow implements Runnable{
	
	TheaterSeat ts;
	
	public BookMyShow(TheaterSeat ts) {
		this.ts=ts;
	}
	
	@Override
	public void run() {
		ts.bookTicket(ts.getSeatNo());
	}
	
	

}
