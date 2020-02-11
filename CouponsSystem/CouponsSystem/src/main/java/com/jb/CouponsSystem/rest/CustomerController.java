package com.jb.CouponsSystem.rest;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.service.CustomerService;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("/add")
	public ResponseEntity<Long> add(@RequestBody Customer customer) {
		service.addCustomer(customer);
		return new ResponseEntity<Long>(customer.getId(), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Long> update(@RequestBody Customer customer) {
		service.updateCustomer(customer);
		return new ResponseEntity<Long>(customer.getId(), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public void delete(@RequestParam(name = "id") long id) {
		service.deleteCustomer(id);
	}

	@GetMapping("/get")
	public ResponseEntity<Customer> getEmployee(@RequestParam(name = "id") long id) {
		return new ResponseEntity<Customer>(service.getOneCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
		return new ResponseEntity<ArrayList<Customer>>(service.getAllCustomers(), HttpStatus.OK);
	}

}
