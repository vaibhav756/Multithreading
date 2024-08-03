package com;

public class Employee {

	Integer empId;
	String empName;
	Double perDaySalary;
	Integer noOfWorkingDays;
	Double salary;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getPerDaySalary() {
		return perDaySalary;
	}
	public void setPerDaySalary(Double perDaySalary) {
		this.perDaySalary = perDaySalary;
	}
	public Integer getNoOfWorkingDays() {
		return noOfWorkingDays;
	}
	public void setNoOfWorkingDays(Integer noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}
	public Employee(Integer empId, String empName, Double perDaySalary, Integer noOfWorkingDays) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.perDaySalary = perDaySalary;
		this.noOfWorkingDays = noOfWorkingDays;
	}
	
}