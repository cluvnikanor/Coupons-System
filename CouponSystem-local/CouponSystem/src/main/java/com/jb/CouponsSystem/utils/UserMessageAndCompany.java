package com.jb.CouponsSystem.utils;

import com.jb.CouponsSystem.beans.Company;

public class UserMessageAndCompany extends UserMessage{
	private Company company;
	
	public UserMessageAndCompany(String message) {
		super(message);
	}

	public UserMessageAndCompany(String message, Company company) {
		super(message);
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "UserMessageAndCompany [company=" + company + "]";
	}
	
}
