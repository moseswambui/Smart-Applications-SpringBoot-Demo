package com.SpringJpa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Entities.ProductEntity;
import com.SpringJpa.Repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Object createProduct(@RequestBody ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    @GetMapping
    public List<ProductEntity> getAllProductEntities(){
        return productRepository.findAll();
    }
}
