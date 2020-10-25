package com.jb.CouponsSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jb.CouponsSystem.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByEmailAndPassword(String email, String password);

	List<Company> findByEmail(String email);

	List<Company> findByName(String name);// not used

	@Transactional
	void deleteByEmail(String email);

//	@Transactional
//	@Modifying
//	@Query(value = "INSERT INTO coupons.companies_coupons (company_id, coupons_id) "
//			+ "VALUES (:companyId, :couponId)", nativeQuery = true)
//	void addCouponCompany(long couponId, long companyId);

}
