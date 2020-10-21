package com.jb.CouponsSystem.rest;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.service.CustomerService;
import com.jb.CouponsSystem.utils.TokenManager;
import com.jb.CouponsSystem.utils.UserMessage;
import com.jb.CouponsSystem.utils.UserMessageAndCoupons;
import com.jb.CouponsSystem.utils.UserMessageAndCustomer;
import com.jb.CouponsSystem.utils.UserType;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	private TokenManager tokenManager;

	@PutMapping("/couponPurchase")
	public ResponseEntity<UserMessage> couponPurchase(@RequestParam(name = "t") String token,
			@RequestParam(name = "couponId") long couponId) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.CUSTOMER)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			customerService.couponPurchase(tokenManager.getUserEmail(UUID.fromString(token)), couponId);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Coupon purchased successfully"), HttpStatus.OK);
	}

	@GetMapping("/getCustomerCoupons")
	public ResponseEntity<UserMessageAndCoupons> getCustomerCoupons(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.CUSTOMER)) {
			return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		List<Coupon> coupons = new ArrayList<>();
		try {
			coupons = customerService.getCustomerCoupons(tokenManager.getUserEmail(UUID.fromString(token)));
		} catch (ServerException e) {
			return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons("", coupons), HttpStatus.OK);
	}

	@GetMapping("/getAllCoupons")
	public ResponseEntity<UserMessageAndCoupons> getAllCoupons(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.CUSTOMER)) {
			return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons("", customerService.getAllCoupons()),
				HttpStatus.OK);
	}

	@GetMapping("/getCustomerDetails")
	public ResponseEntity<UserMessageAndCustomer> getCustomerDetails(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.CUSTOMER)) {
			return new ResponseEntity<UserMessageAndCustomer>(new UserMessageAndCustomer("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		Customer customer = null;
		try {
			customer = customerService.getCustomerByEmail(tokenManager.getUserEmail(UUID.fromString(token))).get(0);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessageAndCustomer>(new UserMessageAndCustomer(e.getMessage()),
					HttpStatus.OK);
		}
		return new ResponseEntity<UserMessageAndCustomer>(new UserMessageAndCustomer("", customer), HttpStatus.OK);
	}
//	@PostMapping("/add")
//	public ResponseEntity<Long> add(@RequestBody Customer customer) {
//		service.addCustomer(customer);
//		return new ResponseEntity<Long>(customer.getId(), HttpStatus.OK);
//	}
//
//	@PostMapping("/update")
//	public ResponseEntity<Long> update(@RequestBody Customer customer) {
//		service.updateCustomer(customer);
//		return new ResponseEntity<Long>(customer.getId(), HttpStatus.OK);
//	}
//
//	@PostMapping("/delete")
//	public void delete(@RequestParam(name = "id") long id) {
//		service.deleteCustomer(id);
//	}
//
//	@GetMapping("/get")
//	public ResponseEntity<Customer> getEmployee(@RequestParam(name = "id") long id) {
//		return new ResponseEntity<Customer>(service.getOneCustomer(id), HttpStatus.OK);
//	}
//
//	@GetMapping("/getAll")
//	public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
//		return new ResponseEntity<ArrayList<Customer>>(service.getAllCustomers(), HttpStatus.OK);
//	}
//
//	@PostMapping("/couponPurchase")
//	public String couponPurchase(@RequestParam(name = "couponId") long couponId,
//			@RequestParam(name = "customerId") long customerId) {
//		String message = "OK";
//		try {
//			couponPurchase.Purchase(couponId, customerId);
//		} catch (Exception e) {
//			message = e.getMessage();
//		}
//		return message;
//	}
//
////	@GetMapping("/login")
////	public ResponseEntity<Customer> login(@RequestParam(name = "email") String email,
////			@RequestParam(name = "password") String password) {
////		return new ResponseEntity<Customer>(customerLogin.login(email, password), HttpStatus.OK);
////	}

}
