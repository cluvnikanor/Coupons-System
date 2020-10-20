//package com.jb.CouponsSystem.logic;
//
//import java.util.Calendar;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.jb.CouponsSystem.service.CouponService;
//
//@Service
//public class CouponPurchase {
//
//	@Autowired
//	CouponService couponService;
//
//	public void Purchase(long couponId, long customerId) throws Exception {
//		// Good, but use's CouponService - another layer
//		if (couponService.hasCustomerId(couponId, customerId))
//			throw new Exception("Customer has already this coupon");
//		int amount = couponService.getAmount(couponId);
//		if (amount < 1)
//			throw new Exception("Coupon out of stock");
//		if (couponService.getEndDate(couponId).before(Calendar.getInstance().getTime()))
//			throw new Exception("Coupon out of date");
//		couponService.addCouponCustomer(couponId, customerId);
//		couponService.setCouponAmount(couponId, amount - 1);
//	}
//
//}
