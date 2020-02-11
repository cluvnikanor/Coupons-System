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
import com.jb.CouponsSystem.logic.CustomerLogin;
import com.jb.CouponsSystem.repo.CouponRepository;
import com.jb.CouponsSystem.service.CompanyService;
import com.jb.CouponsSystem.service.CouponService;
import com.jb.CouponsSystem.service.CustomerService;

@SpringBootApplication // (scanBasePackages= {"com.jb.CouponsSystem"})
public class CouponsSystemApplication {

	public static void main(String[] args) throws Exception {
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

		RestTemplate restTemplate = new RestTemplate();

		CustomerService customerService = ctx.getBean(CustomerService.class);

		CustomerLogin customerLogin = ctx.getBean(CustomerLogin.class);


	}

}
