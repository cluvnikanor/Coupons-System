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
import com.jb.CouponsSystem.service.CouponService;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	CouponService service;

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

}
