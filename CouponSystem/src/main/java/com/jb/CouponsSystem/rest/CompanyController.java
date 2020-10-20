package com.jb.CouponsSystem.rest;

import java.rmi.ServerException;
import java.util.List;
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
import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.service.CompanyService;
import com.jb.CouponsSystem.utils.TokenManager;
import com.jb.CouponsSystem.utils.UserMessage;
import com.jb.CouponsSystem.utils.UserMessageAndCompany;
import com.jb.CouponsSystem.utils.UserMessageAndCoupons;
import com.jb.CouponsSystem.utils.UserType;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	@Autowired
	TokenManager tokenManager;

	@PostMapping("/addCoupon")
	public ResponseEntity<UserMessage> addCompany(@RequestParam(name = "t") String token, @RequestBody Coupon coupon)
			throws Exception {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.COMPANY)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			companyService.addCoupon(coupon, tokenManager.getUserEmail(UUID.fromString(token)));
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Coupon added successfully"), HttpStatus.OK);
	}

	@PutMapping("/updateCoupon")
	public ResponseEntity<UserMessage> updateCoupon(@RequestParam(name = "t") String token,
			@RequestBody Coupon coupon) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.COMPANY)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			companyService.updateCoupon(coupon);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Update successfully"), HttpStatus.OK);
	}

	@PostMapping("/deleteCoupon")
	public ResponseEntity<UserMessage> deleteCoupon(@RequestParam(name = "t") String token,
			@RequestParam(name = "id") long id) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.COMPANY)) {
			return new ResponseEntity<UserMessage>(new UserMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
		}
		try {
			companyService.deleteCoupon(id);
			;
		} catch (ServerException e) {
			return new ResponseEntity<UserMessage>(new UserMessage(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessage>(new UserMessage("Coupon deleted successfully"), HttpStatus.OK);
	}

	@GetMapping("/getAllCoupons")
	public ResponseEntity<UserMessageAndCoupons> getAllCoupons(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.COMPANY)) {
			return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		List<Coupon> coupons = null;
		try {
			coupons = companyService.getAllCoupons(tokenManager.getUserEmail(UUID.fromString(token)));
		} catch (ServerException e) {
			return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessageAndCoupons>(new UserMessageAndCoupons("", coupons), HttpStatus.OK);
	}

	@GetMapping("/getCompanyDetails")
	public ResponseEntity<UserMessageAndCompany> getCompanyDetails(@RequestParam(name = "t") String token) {
		if (!tokenManager.validateUser(UUID.fromString(token), UserType.COMPANY)) {
			return new ResponseEntity<UserMessageAndCompany>(new UserMessageAndCompany("Unauthorized"),
					HttpStatus.UNAUTHORIZED);
		}
		Company company = null;
		try {
			company = companyService.getCompanyByEmail(tokenManager.getUserEmail(UUID.fromString(token))).get(0);
		} catch (ServerException e) {
			return new ResponseEntity<UserMessageAndCompany>(new UserMessageAndCompany(e.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<UserMessageAndCompany>(new UserMessageAndCompany("", company), HttpStatus.OK);
	}
//	@PostMapping("/add")
//	public ResponseEntity<Long> add(@RequestBody Company company) throws Exception {
//		if (!companyService.getCompanyByEmail(company.getEmail()).isEmpty()) {
//			throw new Exception("Can't add company: email is used");
//		}
//		if (!companyService.getCompanyByName(company.getName()).isEmpty()) {
//			throw new Exception("Can't add company: name is used");
//		}
//		companyService.addCompany(company);
//		return new ResponseEntity<Long>(company.getId(), HttpStatus.OK);
//	}
//
//	@PostMapping("/updateEmail&Password")
//	public ResponseEntity<Long> update(@RequestBody Company company) throws Exception {
//		if (companyService.getCompanyById(company.getId()) == null) {
//			throw new Exception("Company id not found");
//		}
//		if (companyService.getCompanyById(company.getId()).getName() != company.getName()) {
//			throw new Exception("Can't update company name");
//		}
//		companyService.updateCompany(company);
//		return new ResponseEntity<Long>(company.getId(), HttpStatus.OK);
//	}
//
//	@PostMapping("/delete")
//	public void delete(@RequestParam(name = "id") long id) {
//		companyService.deleteCompany(id);
//	}
//
//	@GetMapping("/get")
//	public ResponseEntity<Company> getEmployee(@RequestParam(name = "id") long id) {
//		return new ResponseEntity<Company>(companyService.getCompanyById(id), HttpStatus.OK);
//	}
//
//	@GetMapping("/getAll")
//	public ResponseEntity<ArrayList<Company>> getAllCompanies() {
//		return new ResponseEntity<ArrayList<Company>>(companyService.getAllCompanies(), HttpStatus.OK);
//	}

}
