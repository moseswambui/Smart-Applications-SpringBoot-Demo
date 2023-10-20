package com.SpringJpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringJpa.Entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
}
