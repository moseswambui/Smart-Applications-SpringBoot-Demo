package com.SpringJpa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Entities.Company;
import com.SpringJpa.Repositories.CompanyRepository;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping
    public Object createCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    /* 
    @GetMapping
    public Company getCompany(@PathVariable Long id){
        return companyRepository.findById(id)
            .orElseThrow();
    }
    */
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyRepository.deleteById(id);
    }

}
