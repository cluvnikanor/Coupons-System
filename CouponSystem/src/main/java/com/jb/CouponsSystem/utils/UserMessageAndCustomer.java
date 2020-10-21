package com.jb.CouponsSystem.utils;

import com.jb.CouponsSystem.beans.Customer;

public class UserMessageAndCustomer extends UserMessage {

	private Customer customer;

	public UserMessageAndCustomer(String message) {
		super(message);
	}

	public UserMessageAndCustomer(String message, Customer customer) {
		super(message);
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "UserMessageAndCustomer [customer=" + customer + "]";
	}

}
