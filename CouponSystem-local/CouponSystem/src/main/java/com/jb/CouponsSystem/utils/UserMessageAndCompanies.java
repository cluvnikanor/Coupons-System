package com.jb.CouponsSystem.utils;

import java.util.ArrayList;

import com.jb.CouponsSystem.beans.Company;

public class UserMessageAndCompanies extends UserMessage{
	
	private ArrayList<Company> companies;

	public UserMessageAndCompanies(String message) {
		super(message);
	}

	public UserMessageAndCompanies(String message, ArrayList<Company> companies) {
		super(message);
		this.companies = companies;
	}

	public ArrayList<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "UserMessageAndCompanies [companies=" + companies + "]";
	}

}