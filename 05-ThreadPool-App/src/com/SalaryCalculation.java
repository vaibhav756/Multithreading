package com;

public class SalaryCalculation implements Runnable{

	Employee e=null;
	
	public SalaryCalculation(Employee e) {
		this.e = e;
	}

	@Override
	public void run() {
		this.calculateSalary(e);
	}
	
	public void calculateSalary(Employee e)
	{
		Double salary=e.getPerDaySalary()*e.getNoOfWorkingDays();
		System.out.println(e.getEmpName()+"'s Salary is : "+salary+" Thread "+Thread.currentThread().getName());
	}
	
}
