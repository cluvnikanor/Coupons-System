package com.jb.CouponsSystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;
import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.beans.Coupon;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.logic.CouponPurchase;
import com.jb.CouponsSystem.repo.CouponRepository;
import com.jb.CouponsSystem.service.CompanyService;
import com.jb.CouponsSystem.service.CouponService;

@SpringBootApplication//(scanBasePackages= {"com.jb.CouponsSystem"})
public class CouponsSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CouponsSystemApplication.class, args);
		System.out.println("GO");
		
//		CompanyService companyService = ctx.getBean(CompanyService.class);
//
//		
		Company c1 = new Company("Coca Cola", "cocacola@gmail.com", "1234");
		Company c2 = new Company(2, "Pepsi", "pepsi@gmail.com", "1234");
		Company c3 = new Company(11, "Coca Cola", "cocacola@gmail.com", "1234");
				
		Customer cs1 = new Customer(15, null, null, null, null);
		Customer cs2 = new Customer(16, null, null, null, null);
		
		List<Customer> customers1 = new ArrayList<Customer>();
		customers1.add(cs1);
		customers1.add(cs2);
		
		Coupon cp1 = new Coupon(5, 1, 1, "D", "Bla", null, null, 20, 39.90, "picture", customers1);
//		System.out.println(cp1);

		RestTemplate restTemplate = new RestTemplate();
		
//		restTemplate.postForObject("http://localhost:8080/company/add", c3, Long.class);
//		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get?id=1", Company.class));
//		restTemplate.postForObject("http://localhost:8080/coupon/addPurchase?coupon_id=2&customer_id=1", null, String.class);
//		restTemplate.postForObject("http://localhost:8080/coupon/couponPurchase?coupon_id=1&customer_id=1", null, String.class);
		
//		restTemplate.postForObject("http://localhost:8080/customer/add", cs1, Long.class);
//		restTemplate.postForObject("http://localhost:8080/customer/add", cs2, Long.class);
//		restTemplate.postForObject("http://localhost:8080/coupon/add", cp1, Long.class);
//		restTemplate.postForObject("http://localhost:8080/coupon/updateAmount?id=1&amount=14", null, Long.class);
		
		CouponService couponService = ctx.getBean(CouponService.class);
//		couponService.addCouponCustomer2(1L, 1L);
//		couponService.setCouponAmount(1L, 13);
//		System.out.println(couponService.getAmount(100));
		
		
	}

}
