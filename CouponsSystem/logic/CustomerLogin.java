package com.jb.CouponsSystem.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.service.CustomerService;

@Service
public class CustomerLogin {

	@Autowired
	private CustomerService customerService;

	public Customer login (String email, String password) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers = customerService.getCustomerByEmailAndPassword(email, password);
		if (customers.isEmpty()) {
			return new Customer(-1, "", "", "", "");
		}
		return customers.get(0);
	}

}
