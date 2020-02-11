package com.jb.CouponsSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.CouponsSystem.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
