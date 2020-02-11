package com.jb.CouponsSystem.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.repo.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public void addCompany(Company company) {
		companyRepository.save(company);
	}

	public void updateCompany(Company company) {
		companyRepository.save(company);
	}

	public void deleteCompany(long companyId) {
		companyRepository.deleteById((long) companyId);
	}

	public ArrayList<Company> getAllCompanies() {
		return (ArrayList<Company>) companyRepository.findAll();
	}

	public Company getOneCompany(long companyId) {
		return companyRepository.getOne((long) companyId);
	}

}
