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

import com.SpringJpa.Entities.CustomerEntity;
import com.SpringJpa.Repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public Object createCustomer(@RequestBody CustomerEntity customerEntity){
        return customerRepository.save(customerEntity);
    }
    
    @GetMapping
    public List<CustomerEntity> getAllCustomerEntities(){
        return customerRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer (@PathVariable Long id){
        customerRepository.deleteById(id);
    }
}
