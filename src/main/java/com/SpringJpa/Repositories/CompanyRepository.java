package com.SpringJpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringJpa.Entities.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
