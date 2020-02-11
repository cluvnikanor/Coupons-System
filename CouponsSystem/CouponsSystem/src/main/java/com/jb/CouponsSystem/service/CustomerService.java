package com.jb.CouponsSystem.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(long customerId) {
		customerRepository.deleteById((long) customerId);
	}

	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) customerRepository.findAll();

	}

	public Customer getOneCustomer(long CustomerId) {
		return customerRepository.getOne((long) CustomerId);
	}

}
