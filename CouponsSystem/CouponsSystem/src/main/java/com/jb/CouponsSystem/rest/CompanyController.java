package com.jb.CouponsSystem.rest;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.CouponsSystem.beans.Company;
import com.jb.CouponsSystem.service.CompanyService;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService service;

	@PostMapping("/add")
	public ResponseEntity<Long> add(@RequestBody Company company) {
		service.addCompany(company);
		return new ResponseEntity<Long>(company.getId(), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Long> update(@RequestBody Company company) {
		service.updateCompany(company);
		return new ResponseEntity<Long>(company.getId(), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public void delete(@RequestParam(name = "id") long id) {
		service.deleteCompany(id);
	}

	@GetMapping("/get")
	public ResponseEntity<Company> getEmployee(@RequestParam(name = "id") long id) {
		return new ResponseEntity<Company>(service.getOneCompany(id), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<ArrayList<Company>> getAllCompanies() {
		return new ResponseEntity<ArrayList<Company>>(service.getAllCompanies(), HttpStatus.OK);
	}

}
