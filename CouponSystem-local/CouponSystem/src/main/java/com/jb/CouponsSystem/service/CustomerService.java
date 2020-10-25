package com.jb.CouponsSystem.service;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.repo.CouponRepository;
import com.jb.CouponsSystem.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CouponRepository couponRepository;

	public void couponPurchase(String customerEmail, long couponId) throws ServerException {
		if (customerRepository.findByEmail(customerEmail).size() == 0) {
			throw new ServerException("Can't purchase coupon: customer not found");
		}
		if (couponRepository.findById(couponId) == null) {
			throw new ServerException("Can't purchase coupon: coupon not found");
		}
		Customer customer = customerRepository.findByEmail(customerEmail).get(0);
		Coupon coupon = couponRepository.getOne(couponId);
		if (customer.getCoupons().contains(coupon)) {
			throw new ServerException("Can't purchase coupon: customer has already this coupon");
		}
		if (coupon.getAmount() < 1) {
			throw new ServerException("Can't purchase coupon: coupon is out of stock");
		}
		if (coupon.getEndDate().before(Calendar.getInstance().getTime())) {
			throw new ServerException("Can't purchase coupon: coupon is out of date");
		}
		customer.addCoupon(coupon);
		customerRepository.save(customer);
		coupon.setAmount(coupon.getAmount() - 1);
		couponRepository.save(coupon);
	}

	public List<Coupon> getCustomerCoupons(String customerEmail) throws ServerException {
		if (customerRepository.findByEmail(customerEmail).size() == 0) {
			throw new ServerException("Can't find coupons: customer not found");
		}
		Customer customer = customerRepository.findByEmail(customerEmail).get(0);
		return customer.getCoupons();
	}

	public List<Coupon> getAllCoupons() {
		return couponRepository.findAll();
	}

	public List<Customer> getCustomerByEmail(String email) throws ServerException {
		if (customerRepository.findByEmail(email).size() == 0) {
			throw new ServerException("Can't find customer: email not found");
		}
		return customerRepository.findByEmail(email);
	}

	public ArrayList<Customer> getCustomerByEmailAndPassword(String email, String password) {
		return (ArrayList<Customer>) customerRepository.findByEmailAndPassword(email, password);
	}

}
