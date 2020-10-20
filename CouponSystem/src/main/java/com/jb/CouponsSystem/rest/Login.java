package com.jb.CouponsSystem.rest;

import java.rmi.ServerException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.service.AdminService;
import com.jb.CouponsSystem.service.CompanyService;
import com.jb.CouponsSystem.service.CustomerService;
import com.jb.CouponsSystem.utils.TokenManager;
import com.jb.CouponsSystem.utils.UserData;
import com.jb.CouponsSystem.utils.UserResponse;
import com.jb.CouponsSystem.utils.UserType;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class Login {
	@Autowired
	TokenManager tokenManager;
	@Autowired
	CompanyService companyService;
	@Autowired
	CustomerService customerService;
	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public ResponseEntity<UserResponse> userLogin(@RequestParam(name = "type") String type,
			@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		if (type.equalsIgnoreCase(UserType.ADMIN.toString())) {
			if (!(email.equals("admin@admin.com") && password.equals("admin"))) {
				return new ResponseEntity<UserResponse>(new UserResponse("Username or password incorrect"),
						HttpStatus.OK);
			}
		}

		if (type.equalsIgnoreCase(UserType.CUSTOMER.toString())) {
			if (customerService.getCustomerByEmailAndPassword(email, password).isEmpty()) {
				return new ResponseEntity<UserResponse>(new UserResponse("Username or password incorrect"),
						HttpStatus.OK);
			}
		}

		if (type.equalsIgnoreCase(UserType.COMPANY.toString())) {
			if (companyService.getCompanyByEmailAndPassword(email, password).isEmpty()) {
				return new ResponseEntity<UserResponse>(new UserResponse("Username or password incorrect"),
						HttpStatus.OK);
			}
		}

		UUID uuid = UUID.randomUUID();
		tokenManager.addUser(uuid, new UserData(UserType.valueOf(type), email));
		return new ResponseEntity<UserResponse>(new UserResponse(uuid.toString(), "Welcome"), HttpStatus.OK);
	}

	@PostMapping("/companyRegister")
	public ResponseEntity<UserResponse> companyRegister(@RequestBody Company company) {
		try {
			adminService.addCompany(company);
		} catch (ServerException e) {
			return new ResponseEntity<UserResponse>(new UserResponse(e.getMessage()), HttpStatus.OK);
		}
		UUID uuid = UUID.randomUUID();
		tokenManager.addUser(uuid, new UserData(UserType.COMPANY, company.getEmail()));
		return new ResponseEntity<UserResponse>(new UserResponse(uuid.toString(), "Company registered succesfully"),
				HttpStatus.OK);
	}

	@PostMapping("/customerRegister")
	public ResponseEntity<UserResponse> customerRegister(@RequestBody Customer customer) {
		try {
			adminService.addCustomer(customer);
		} catch (ServerException e) {
			return new ResponseEntity<UserResponse>(new UserResponse(e.getMessage()), HttpStatus.OK);
		}
		UUID uuid = UUID.randomUUID();
		tokenManager.addUser(uuid, new UserData(UserType.CUSTOMER, customer.getEmail()));
		return new ResponseEntity<UserResponse>(new UserResponse(uuid.toString(), "Customer registered successfully"),
				HttpStatus.OK);
	}

	@GetMapping("/logout")
	public ResponseEntity<UserResponse> logout(@RequestParam(name = "t") String token) {
		if (token != "") {
			tokenManager.removeUser(UUID.fromString(token));
			return new ResponseEntity<UserResponse>(new UserResponse("Logout successfully"), HttpStatus.OK);
		}
		return new ResponseEntity<UserResponse>(new UserResponse(""), HttpStatus.OK);
	}

}
