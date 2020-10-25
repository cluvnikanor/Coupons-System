package com.jb.CouponsSystem.rest;

import java.rmi.ServerException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.service.AdminService;
import com.jb.CouponsSystem.utils.TokenManager;
import com.jb.CouponsSystem.utils.UserMessage;
import com.jb.CouponsSystem.utils.UserMessageAndCompanies;
import com.jb.CouponsSystem.utils.UserMessageAndCompany;
import com.jb.CouponsSystem.utils.UserMessageAndCustomer;
import com.jb.CouponsSystem.utils.UserMessageAndCustomers;
import com.jb.CouponsSystem.utils.UserType;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private TokenManager tokenManager;

	@PostMapping("/addCompany")
	public ResponseEntity<UserMessage> addCompany(@RequestParam(name = "t") String token, @RequestBody Company company)
			throws Exception {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.addCompany(company);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Company added successfully"), HttpStatus.OK);
	}

	@PutMapping("/updateCompany")
	public ResponseEntity<UserMessage> updateCompany(@RequestParam(name = "t") String token,
			@RequestParam(name = "existEmail") String existEmail, @RequestParam(name = "newEmail") String newEmail,
			@RequestParam(name = "newPassword") String newPassword) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.updateCompany(existEmail, newEmail, newPassword);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Update successfully"), HttpStatus.OK);
	}

	@PutMapping("/updateCompany2")
	public ResponseEntity<UserMessage> updateCompany2(@RequestParam(name = "t") String token,
			@RequestParam(name = "companyId") long companyId, @RequestParam(name = "newEmail") String newEmail,
			@RequestParam(name = "newPassword") String newPassword) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.updateCompany2(companyId, newEmail, newPassword);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Update successfully"), HttpStatus.OK);
	}

	@PostMapping("/deleteCompany")
	public ResponseEntity<UserMessage> deleteCompany(@RequestParam(name = "t") String token,
			@RequestParam(name = "email") String email) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.deleteCompany(email);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Company deleted successfully"), HttpStatus.OK);
	}

	@GetMapping("/getCompany")
	public ResponseEntity<UserMessageAndCompany> getCompany(@RequestParam(name = "t") String token,
			@RequestParam(name = "email") String email) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessageAndCompany>(new UserMessageAndCompany("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		Company company = null;
		try {
			company = adminService.getCompanyByEmail(email).get(0);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessageAndCompany>(new UserMessageAndCompany(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessageAndCompany>(new UserMessageAndCompany("", company), HttpStatus.OK);
	}

	@GetMapping("/getAllCompanies")
	public ResponseEntity<UserMessageAndCompanies> getAllCompanies(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessageAndCompanies>(new UserMessageAndCompanies("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<UserMessageAndCompanies>(
				new UserMessageAndCompanies("", adminService.getAllCompanies()), HttpStatus.OK);
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<UserMessage> addCustomer(@RequestParam(name = "t") String token,
			@RequestBody Customer customer) throws Exception {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.addCustomer(customer);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Customer added successfully"), HttpStatus.OK);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<UserMessage> updateCustomer(@RequestParam(name = "t") String token,
			@RequestParam(name = "existEmail") String existEmail, @RequestParam(name = "newEmail") String newEmail,
			@RequestParam(name = "newPassword") String newPassword) throws Exception {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.updateCustomer(existEmail, newEmail, newPassword);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Update successfully"), HttpStatus.OK);
	}

	@PutMapping("/updateCustomer2")
	public ResponseEntity<UserMessage> updateCustomer2(@RequestParam(name = "t") String token,
			@RequestParam(name = "customerId") long customerId, @RequestParam(name = "newEmail") String newEmail,
			@RequestParam(name = "newPassword") String newPassword) throws Exception {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.updateCustomer2(customerId, newEmail, newPassword);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Update successfully"), HttpStatus.OK);
	}

	@PostMapping("/deleteCustomer")
	public ResponseEntity<UserMessage> deleteCustomer(@RequestParam(name = "t") String token,
			@RequestParam(name = "email") String email) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			adminService.deleteCustomer(email);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Customer deleted successfully"), HttpStatus.OK);
	}

	@GetMapping("/getCustomer")
	public ResponseEntity<UserMessageAndCustomer> getCustomer(@RequestParam(name = "t") String token,
			@RequestParam(name = "email") String email) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessageAndCustomer>(new UserMessageAndCustomer("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		Customer customer = null;
		try {
			customer = adminService.getCustomerByEmail(email).get(0);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessageAndCustomer>(new UserMessageAndCustomer(e.getMessage()),
					HttpStatus.OK);
		}
		return new ResponseEntity<UserMessageAndCustomer>(new UserMessageAndCustomer("", customer), HttpStatus.OK);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<UserMessageAndCustomers> getAllCustomers(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.ADMIN)) {
			return new ResponseEntity<UserMessageAndCustomers>(new UserMessageAndCustomers("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<UserMessageAndCustomers>(
				new UserMessageAndCustomers("", adminService.getAllCustomers()), HttpStatus.OK);
	}
}
