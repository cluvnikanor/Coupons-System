package com.jb.CouponsSystem.utils;

import java.util.ArrayList;

import com.jb.CouponsSystem.beans.Customer;

public class UserMessageAndCustomers extends UserMessage {
	
	private ArrayList<Customer> customers;

	public UserMessageAndCustomers(String message) {
		super(message);
	}

	public UserMessageAndCustomers(String message, ArrayList<Customer> customers) {
		super(message);
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "UserMessageAndCustomers [customers=" + customers + "]";
	}

}