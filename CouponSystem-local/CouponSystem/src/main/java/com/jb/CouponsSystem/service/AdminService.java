package com.jb.CouponsSystem.service;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.beans.Customer;
import com.jb.CouponsSystem.repo.CompanyRepository;
import com.jb.CouponsSystem.repo.CouponRepository;
import com.jb.CouponsSystem.repo.CustomerRepository;

@Service
public class AdminService {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	CustomerRepository customerRepository;

	public void addCompany(Company company) throws ServerException {
		if (companyRepository.findByEmail(company.getEmail()).size() != 0) {
			throw new ServerException("Can't add company: email is used");
		}
		if (companyRepository.findByName(company.getName()).size() != 0) {
			throw new ServerException("Can't add company: name is used");
		}
		companyRepository.save(company);
	}

	public void updateCompany(String existEmail, String newEmail, String newPassword) throws ServerException {
		if (companyRepository.findByEmail(existEmail).size() == 0) {
			throw new ServerException("Can't update company: email not found");
		}
		Company company = companyRepository.findByEmail(existEmail).get(0);
		company.setEmail(newEmail);
		company.setPassword(newPassword);
		companyRepository.save(company);
	}

	public void updateCompany2(long companyId, String newEmail, String newPassword) throws ServerException {
		if (companyRepository.getOne(companyId) == null) {
			throw new ServerException("Can't update company: company not found");
		}
		Company company = companyRepository.getOne(companyId);
		company.setEmail(newEmail);
		company.setPassword(newPassword);
		companyRepository.save(company);
	}

	public void deleteCompany(String email) throws ServerException {
		if (companyRepository.findByEmail(email).size() == 0) {
			throw new ServerException("Can't delete company: email not found");
		}
		Company company = companyRepository.findByEmail(email).get(0);
		couponRepository.deleteCompanyCoupons(company.getId());
		companyRepository.deleteByEmail(email);
	}

	public List<Company> getCompanyByEmail(String email) throws ServerException {
		if (companyRepository.findByEmail(email).size() == 0) {
			throw new ServerException("Email not found");
		}
		return companyRepository.findByEmail(email);
	}

	public ArrayList<Company> getAllCompanies() {
		return (ArrayList<Company>) companyRepository.findAll();
	}

	public void addCustomer(Customer customer) throws ServerException {
		if (!(customerRepository.findByEmail(customer.getEmail()).size() == 0)) {
			throw new ServerException("Can't add company: email is used");
		}
		customerRepository.save(customer);
	}

	public void updateCustomer(String existEmail, String newEmail, String newPassword) throws ServerException {
		if (customerRepository.findByEmail(existEmail).size() == 0) {
			throw new ServerException("Can't update customer: email not found");
		}
		Customer customer = customerRepository.findByEmail(existEmail).get(0);
		customer.setEmail(newEmail);
		customer.setPassword(newPassword);
		customerRepository.save(customer);
	}
	
	public void updateCustomer2(long customerId, String newEmail, String newPassword) throws ServerException {
		if (customerRepository.getOne(customerId) == null) {
			throw new ServerException("Can't update customer: email not found");
		}
		Customer customer = customerRepository.getOne(customerId);
		customer.setEmail(newEmail);
		customer.setPassword(newPassword);
		customerRepository.save(customer);
	}

	public void deleteCustomer(String email) throws ServerException {
		if (customerRepository.findByEmail(email).size() == 0) {
			throw new ServerException("Can't delete customer: email not found");
		}
		Customer customer = customerRepository.findByEmail(email).get(0);
//		customerRepository.deleteCustomerCoupons(customer.getId());
		customerRepository.deleteByEmail(email);
	}

	public List<Customer> getCustomerByEmail(String email) throws ServerException {
		if (customerRepository.findByEmail(email).size() == 0) {
			throw new ServerException("Email not found");
		}
		return customerRepository.findByEmail(email);
	}

	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) customerRepository.findAll();
	}

}
