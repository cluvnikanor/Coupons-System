package com.jb.CouponsSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jb.CouponsSystem.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByEmailAndPassword(String email, String password);

	List<Customer> findByEmail(String email);

	@Transactional
	void deleteByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM coupons.customers_coupons WHERE coupon_id = :couponId", nativeQuery = true)
	void deleteCustomerCoupons(long couponId);

}
