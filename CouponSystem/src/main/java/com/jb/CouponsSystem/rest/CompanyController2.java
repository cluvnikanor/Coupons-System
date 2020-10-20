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

import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.service.CompanyService;
import com.jb.CouponsSystem.service.CouponService;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/companyUser") // Change later to "/company"
public class CompanyController2 {

	@Autowired
	CompanyService companyService;
	CouponService couponService;

//	@GetMapping("/login")

	@PostMapping("/addCoupon")
	public ResponseEntity<Long> addCoupon(@RequestBody Coupon coupon) {
		couponService.addCoupon(coupon);
		return new ResponseEntity<Long>(coupon.getId(), HttpStatus.OK);
	}

	@PostMapping("/updateCoupon")
	public ResponseEntity<Long> updateCoupon(@RequestBody Coupon coupon) {
		couponService.addCoupon(coupon);
		return new ResponseEntity<Long>(coupon.getId(), HttpStatus.OK);
	}

	@PostMapping("/deleteCoupon")
	public void deleteCoupon(@RequestParam(name = "id") long id) {
		couponService.deleteCoupon(id);
	}

	@GetMapping("/getAllCoupons") /* CHANGE! NO COMPANY ID! */
	public ResponseEntity<List<Coupon>> getAllCoupons(@RequestParam(name = "companyId") long companyId) {
		return new ResponseEntity<List<Coupon>>(couponService.getCouponsByCompanyId(companyId), HttpStatus.OK);
	}

//	@GetMapping("/getCouponsFromCategory") /* CHANGE! NO COMPANY ID! */
//	public ResponseEntity<List<Coupon>> getCouponsFromCategory(@RequestParam(name = "companyId") long companyId,
//			@RequestParam(name = "categoryId") long categoryId) {
//		return new ResponseEntity<List<Coupon>>(couponService.getCouponsByCompanyIdAndCategoryId(companyId, categoryId), HttpStatus.OK);
//	}

	@GetMapping("/getCouponsBetweenPrices") /* CHANGE! NO COMPANY ID! */
	public ResponseEntity<List<Coupon>> getCouponsBetweenPrices(@RequestParam(name = "companyId") long companyId,
			@RequestParam(name = "minPrice") Double minPrice, @RequestParam(name = "maxPrice") Double maxPrice) {
		return new ResponseEntity<List<Coupon>>(
				couponService.getCouponsByCompanyIdBetweenPrices(companyId, minPrice, maxPrice), HttpStatus.OK);
	}

	@GetMapping("/getCompanyDetails") /* CHANGE! NO COMPANY ID! */
	public ResponseEntity<Company> getCompanyDetails(@RequestParam(name = "id") long id) {
		return new ResponseEntity<Company>(companyService.getCompanyById(id), HttpStatus.OK);
	}

}
