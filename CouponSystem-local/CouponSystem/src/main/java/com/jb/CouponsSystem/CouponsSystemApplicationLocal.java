package com.jb.CouponsSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // (scanBasePackages= {"com.jb.CouponsSystem"})
public class CouponsSystemApplicationLocal {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		ApplicationContext ctx = SpringApplication.run(CouponsSystemApplicationLocal.class, args);
		System.out.println("GO");

//		CompanyService companyService = ctx.getBean(CompanyService.class);
//
//		
//		Company c1 = new Company("Coca Cola", "cocacola@gmail.com", "1234");
//		Company c2 = new Company(2, "Pepsi", "pepsi@gmail.com", "1234");
//		//Company c3 = new Company(11, "Coca Cola", "cocacola@gmail.com", "1234");
//
//		Customer cs1 = new Customer(15, null, null, null, null);
//		Customer cs2 = new Customer(16, null, null, null, null);
//
//		List<Customer> customers1 = new ArrayList<Customer>();
//		customers1.add(cs1);
//		customers1.add(cs2);
//
//		Coupon cp1 = new Coupon(5, 1, 1, "D", "Bla", null, null, 20, 39.90, "picture", customers1);
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		AdminService adminService = ctx.getBean(AdminService.class);
//		adminService.deleteCompany("osem@gmail.com");

	}

}
