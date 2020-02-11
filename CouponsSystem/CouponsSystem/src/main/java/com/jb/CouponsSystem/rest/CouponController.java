package com.jb.CouponsSystem.rest;

import java.util.List;

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

import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.logic.CouponPurchase;
import com.jb.CouponsSystem.service.CouponService;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	CouponService service;
	@Autowired
	CouponPurchase couponPurchase;

	@PostMapping("/add")
	public ResponseEntity<Long> add(@RequestBody Coupon coupon) {
		service.addCoupon(coupon);
		return new ResponseEntity<Long>(coupon.getId(), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public void delete(@RequestParam(name = "id") long id) {
		service.deleteCoupon(id);
	}

	@GetMapping("/get")
	public ResponseEntity<Coupon> getEmployee(@RequestParam(name = "id") long id) {
		return new ResponseEntity<Coupon>(service.getOneCoupon(id), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Coupon>> getAllCoupon() {
		return new ResponseEntity<List<Coupon>>(service.getAllCoupons(), HttpStatus.OK);
	}

	@PostMapping("/updateAmount")
	public void updateAmount(@RequestParam(name = "id") long id, 
			@RequestParam(name = "amount") int amount) {
		service.setCouponAmount(id, amount);
	}

//	@PostMapping("/addCouponCustomer")
//	public void addCouponCustomer(@RequestParam(name = "couponId") long couponId,
//			@RequestParam(name = "customerId") long customerId) {
//		couponPurchase.addCouponCustomer(couponId, customerId);
//	}

	@PostMapping("/couponPurchase")
	public String couponPurchase(@RequestParam(name = "couponId") long couponId,
			@RequestParam(name = "customerId") long customerId) {
		String message = "OK";
		try {
			couponPurchase.Purchase(couponId, customerId);
		} catch (Exception e) {
			message = e.getMessage();
		}
		return message;
	}

}
