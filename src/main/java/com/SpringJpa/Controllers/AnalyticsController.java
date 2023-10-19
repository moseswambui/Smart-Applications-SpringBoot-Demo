package com.SpringJpa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Repositories.CompanyRepository;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/company-count")
    public ResponseEntity<Long> getCompanyCount(){
        long count = companyRepository.count();
        return ResponseEntity.ok(count);
    }
}
