package com.jb.CouponsSystem.repo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jb.CouponsSystem.beans.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO coupons.coupons_customers (coupon_id, customers_id)"
			+ " VALUES (:couponId, :customerId)", nativeQuery = true)
	void addCouponCustomer(long couponId, long customerId);// works

	@Query(value = "SELECT customers_id FROM coupons.coupons_customers "
			+ "WHERE coupon_id = :couponId AND customers_id = :customerId", nativeQuery = true)
	int findByIdByCustomerId(long couponId, long customerId);// works. Surround by try/catch

	@Transactional
	@Modifying
	@Query("UPDATE Coupon c SET c.amount = :couponAmount WHERE c.id = :couponId")
	void setAmountById(Long couponId, Integer couponAmount);// works

//	@Query("SELECT c.amount FROM Coupon c WHERE c.id = :couponId")
//	int findAmountyById(long couponId);//works. Surround by try/catch

	int findAmountById(long couponId);

	@Query("SELECT c.endDate FROM Coupon c WHERE c.id = :couponId")
	Date findEndDateById(long couponId);// works. Surround by try/catch

	List<Coupon> findAllByCompanyId(long companyId);

	@Query("SELECT c FROM Coupon c WHERE c.companyId = :companyId AND c.price >= :minPrice AND c.price <= :maxPrice")
	List<Coupon> findAllByCompanyBetweenPrices(long companyId, Double minPrice, Double maxPrice);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM coupons WHERE company_id = :companyId", nativeQuery = true)
	void deleteCompanyCoupons(long companyId);

	@Query(value = "SELECT customers_id FROM coupons.coupons_customers "
			+ "WHERE customer_id = :customerId", nativeQuery = true)
	List<Long> findAllIdsByCustomerId(long customerId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM coupons WHERE end_date > :endDate", nativeQuery = true)
	void deleteAllByEndDate(LocalDate endDate);
}
