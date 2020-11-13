package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;


public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
		
	public JobsController(){
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		AbsStaffMember boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);		
	}

	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{	
		AbsStaffMember employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		AbsStaffMember manager = new Employee (name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager() );
		repository.addMember(manager);
	}
		
	
	public void payAllEmployeers() {		
		for (AbsStaffMember elem:repository.getAllMembers()){
			elem.pay();	
		}
	}
			

	public String getAllEmployees() {
		String message="";
		
		for (AbsStaffMember elem: repository.getAllMembers()) {
			message+=elem.toString();
		}
		return message;
	}
	
	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		AbsStaffMember volunteer = new Volunteer (name, address, phone, description );
		repository.addMember(volunteer);		
	}
		
}
