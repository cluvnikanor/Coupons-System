package com.jb.CouponsSystem.service;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.repo.CompanyRepository;
import com.jb.CouponsSystem.repo.CouponRepository;
import com.jb.CouponsSystem.repo.CustomerRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CustomerRepository customerRepository;

	// new
	public void addCoupon(Coupon coupon, String companyEmail) throws ServerException {
		if (companyRepository.findByEmail(companyEmail).isEmpty()) {
			throw new ServerException("Can't add coupon: company not found");
		}
		long companyId = companyRepository.findByEmail(companyEmail).get(0).getId();
		coupon.setCompanyId(companyId);
		couponRepository.save(coupon);
	}

	// new
	public void deleteCoupon(long couponId) throws ServerException {
		if (couponRepository.findById(couponId).isEmpty()) {
			throw new ServerException("Coupon not found");
		}
//		customerRepository.deleteCustomerCoupons(couponId);// It's allowed?
		couponRepository.deleteById(couponId);
	}

	// new
	public List<Coupon> getAllCoupons(String companyEmail) throws ServerException {
		if (companyRepository.findByEmail(companyEmail).isEmpty()) {
			throw new ServerException("Can't find coupons: company not found");
		}
		return (List<Coupon>) couponRepository
				.findAllByCompanyId(companyRepository.findByEmail(companyEmail).get(0).getId());
	}

	// Important for login
	public List<Company> getCompanyByEmailAndPassword(String email, String password) {
		return companyRepository.findByEmailAndPassword(email, password);
	}

	public void addCompany(Company company) {
		companyRepository.save(company);
	}

	public void updateCompany(Company company) {
		companyRepository.save(company);
	}

	public void deleteCompany(long companyId) {
		companyRepository.deleteById((long) companyId);
	}

	public Company getCompanyById(long companyId) {
		return companyRepository.getOne((long) companyId);
	}

	public List<Company> getCompanyByEmail(String email) {
		return companyRepository.findByEmail(email);
	}

	public List<Company> getCompanyByName(String name) {
		return companyRepository.findByName(name);
	}

}
