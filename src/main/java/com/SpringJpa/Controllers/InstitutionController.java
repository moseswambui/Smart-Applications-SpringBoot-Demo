package com.SpringJpa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Entities.InstitutionEntity;
import com.SpringJpa.Repositories.InstitutionRepository;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    private InstitutionRepository institutionRepository;

    @PostMapping
    public Object createInstitution(@RequestBody InstitutionEntity institutionEntity){
        return institutionRepository.save(institutionEntity);
    }

    @GetMapping
    public List<InstitutionEntity> getAllInstitutionEntities(){
        return institutionRepository.findAll();
    }
    
}
