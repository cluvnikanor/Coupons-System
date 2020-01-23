package com.jb.CouponsSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb.CouponsSystem.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
