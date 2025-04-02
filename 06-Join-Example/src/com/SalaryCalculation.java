package com;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class SalaryCalculation implements Callable<Employee>{

	public Employee e=null;
	CountDownLatch latch=new CountDownLatch(10);

	public SalaryCalculation(Employee e,CountDownLatch latch) {
		this.e=e;
		this.latch=latch;
	}
	
	@Override
	public Employee call() throws Exception {
		latch.countDown();
		return calculateSalary(e);
	}

	private Employee calculateSalary(Employee emp) {
		Double salary=emp.getNoOfWorkingDays()*emp.getPerDaySalary();
		emp.salary=salary;
		return emp;
	}
	
}
