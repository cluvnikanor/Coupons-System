package com.jb.CouponsSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;
import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.service.CompanyService;

@SpringBootApplication
public class CouponsSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CouponsSystemApplication.class, args);
		System.out.println("GO");
		
		CompanyService companyService = ctx.getBean(CompanyService.class);

		
		Company c1 = new Company("Coca Cola", "cocacola@gmail.com", "1234");
		Company c2 = new Company("Pepsi", "pepsi@gmail.com", "1234");
		
		RestTemplate restTemplate = new RestTemplate();
		
//		restTemplate.postForObject("http://localhost:8080/company/add", c2, Long.class);
//		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get?id=1", Company.class));


	}

}
