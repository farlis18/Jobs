package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		
		if(description.contentEquals("")) throw new Exception();
		this.description = description;
	}
	
	@Override
	public void pay() {
	}
	
	public String toString() {
		String details="\n" +
				"Id: " + id +
				"\tName: " + name + 
				"\tAddress: " + address +
				"\tPhone: "  + phone +
				"\tDescription: " + description;
		
		return details;	
	}
	
}
