package com.SpringJpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringJpa.Entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    
}
