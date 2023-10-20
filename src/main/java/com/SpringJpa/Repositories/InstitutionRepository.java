package com.SpringJpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringJpa.Entities.InstitutionEntity;

public interface InstitutionRepository extends JpaRepository<InstitutionEntity, Long> {
    
}
