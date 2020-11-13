package com.jobs.domain;

public class Employee extends AbsStaffMember {

	private double salaryPerMonth; 
	private IPaymentRate paymentRate;	

		public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone);	
		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();		
		
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}
	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
		
	public String toString() {
		String details="\n" +
				"Id: " + id + 
				"\tName: " + name +
				"\tAddress: " + address +
				"\tPhone: "  + phone + 
				"\tSalary: " + salaryPerMonth + 
				"\tTotal Paid: " + totalPaid;
		
		return details;	
	}

}
