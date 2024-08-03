package com;

import java.util.concurrent.Callable;

public class SalaryCalculationWithCallable implements Callable<Employee>{

	Employee e=null;
	
	public SalaryCalculationWithCallable(Employee e) {
		this.e = e;
	}

	@Override
	public Employee call() throws Exception {
		calculateSalary(e);
		return e;
	}
	
	public void calculateSalary(Employee e)
	{
		Double salary=e.getPerDaySalary()*e.getNoOfWorkingDays();
		//System.out.println(e.getEmpName()+"'s Salary is : "+salary+" Thread "+Thread.currentThread().getName());
		e.salary=salary;
	}
	
}
