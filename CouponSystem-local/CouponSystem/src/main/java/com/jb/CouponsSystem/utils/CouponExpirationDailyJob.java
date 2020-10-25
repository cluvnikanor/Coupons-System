package com.jb.CouponsSystem.utils;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.jb.CouponsSystem.repo.CouponRepository;

public class CouponExpirationDailyJob {
	@Autowired
	CouponRepository couponRepository;

	@Scheduled(fixedRate = 1000 * 1440)
	public void deleteExpiredCoupons() {
		couponRepository.deleteAllByEndDate(LocalDate.now());
	}
}
