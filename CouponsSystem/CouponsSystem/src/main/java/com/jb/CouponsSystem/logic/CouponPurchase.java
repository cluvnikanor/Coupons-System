package com.jb.CouponsSystem.logic;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.service.CouponService;
import com.jb.CouponsSystem.service.CustomerService;

@Service
public class CouponPurchase {
	Coupon coupon;
	Customer customer;

	@Autowired
	CouponService couponService;

	@Autowired
	CustomerService customerService;
	

	public void Purchase(long couponId, long customerId) throws Exception {
		// Good, but use's CouponService - another layer
		if (couponService.hasCustomerId(couponId, customerId))
			throw new Exception("Customer has already this coupon");
		int amount = couponService.getAmount(couponId);
		if (amount < 1)
			throw new Exception("Coupon out of stock");
		if (couponService.getEndDate(couponId).before(Calendar.getInstance().getTime()))
			throw new Exception("Coupon out of date");
		couponService.addCouponCustomer(couponId, customerId);
		couponService.setCouponAmount(couponId, amount - 1);
	}

//	public void Purchase2(long couponId, long customerId) throws Exception {
//		this.coupon = couponService.getOneCoupon(couponId);// Too much data!
//		this.customer = customerService.getOneCustomer(customerId);
//		if (coupon.getCustomers().contains(customer))
//			throw new Exception("Customer has already this coupon");
//		if (coupon.getAmount() < 1)
//			throw new Exception("Coupon out of stock");
//		if (coupon.getEndDate().after(Calendar.getInstance().getTime()))
//			throw new Exception("Coupon out of date");
//		List<Customer> customers = coupon.getCustomers();
//		customers.add(customer);
//		coupon.setAmount(coupon.getAmount() - 1);
//		couponService.deleteCoupon(couponId);// Delete & add new one, only to change two fields. That's a waste!
//		couponService.addCoupon(coupon);
//	}
//
//	public void Purchase1(long couponId, long customerId) throws Exception {
//		this.coupon = couponService.getOneCoupon(couponId);// Too much data!
//		this.customer = customerService.getOneCustomer(customerId);
//		if (coupon.getCustomers().contains(customer))
//			throw new Exception("Customer has already this coupon");
//		if (coupon.getAmount() < 1)
//			throw new Exception("Coupon out of stock");
//		if (coupon.getEndDate().before(Calendar.getInstance().getTime()))
//			throw new Exception("Coupon out of date");
//		if (coupon.getStartDate().after(Calendar.getInstance().getTime()))
//			throw new Exception("Coupon invalid");
//		couponService.addCouponCustomer(couponId, customerId);
//		couponService.setCouponAmount(couponId, coupon.getAmount() - 1);
//	}

}
