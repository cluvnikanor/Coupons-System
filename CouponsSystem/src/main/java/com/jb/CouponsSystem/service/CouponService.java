package com.jb.CouponsSystem.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.repo.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public void addCoupon(Coupon coupon) {
		couponRepository.save(coupon);
	}

	public void deleteCoupon(long couponId) {
		couponRepository.deleteById(couponId);
	}

	public List<Coupon> getAllCoupons() {
		return (List<Coupon>) couponRepository.findAll();
	}

	public Coupon getOneCoupon(long couponId) {
		return couponRepository.getOne(couponId);
	}

	public void setCouponAmount(long couponId, int couponAmount) {// Custom query
		couponRepository.setAmountById(couponId, couponAmount);
	}

	public void addCouponCustomer(long couponId, long customerId) {// Custom query
		couponRepository.addCouponCustomer(couponId, customerId);
	};

	public boolean hasCustomerId(long couponId, long customerId) {// Custom query
		try {
			if (couponRepository.findByIdByCustomerId(couponId, customerId) >= 0)
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public int getAmount(long couponId) {// Custom query
		try {
			return couponRepository.findAmountyById(couponId);
		} catch (Exception e) {
		}
		return -1;
	}

	public Date getEndDate(long couponId) { // Custom query; Surround by try/catch!
		return couponRepository.findEndDateById(couponId);
	}

}
