package com.jb.CouponsSystem.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jb.CouponsSystem.beans.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
	@Transactional
	@Modifying
	@Query(value = 
		"INSERT INTO coupons.coupons_customers (coupon_id, customers_id)"
		+ " VALUES (:couponId, :customerId)", nativeQuery = true)
	void addCouponCustomer(long couponId, long customerId);//works

	@Query(value = 
			"SELECT customers_id FROM coupons.coupons_customers "
			+ "WHERE coupon_id = :couponId AND customers_id = :customerId",
			nativeQuery = true)
	int findByIdByCustomerId(long couponId, long customerId);//works. Surround by try/catch
	
	@Transactional
	@Modifying
	@Query("UPDATE Coupon c SET c.amount = :couponAmount WHERE c.id = :couponId")
	void setAmountById(Long couponId, Integer couponAmount);//works

	@Query("SELECT c.amount FROM Coupon c WHERE c.id = :couponId")
	int findAmountyById(long couponId);//works. Surround by try/catch
	
	@Query("SELECT c.endDate FROM Coupon c WHERE c.id = :couponId")
	Date findEndDateById(long couponId);//works. Surround by try/catch

}
