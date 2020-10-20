package com.jb.CouponsSystem.utils;

import java.util.List;

import com.jb.CouponsSystem.beans.Coupon;

public class UserMessageAndCoupons extends UserMessage {
	private List<Coupon> coupons;

	public UserMessageAndCoupons(String message) {
		super(message);
	}

	public UserMessageAndCoupons(String message, List<Coupon> coupons) {
		super(message);
		this.coupons = coupons;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "UserMessageAndCoupons [coupons=" + coupons + "]";
	}

}
