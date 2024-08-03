package com;

public class NumberPrinting implements Runnable{

	Integer val=0;
	
	public NumberPrinting(Integer val) {
		this.val=val;
	}
	
	@Override
	public void run() {
		System.out.println(val+" Thread : "+Thread.currentThread().getName());
	}
	
}
