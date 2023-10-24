package com.SpringJpa.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String designation;

    @Column
    private String contactInfo;

    /* 
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();

    
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstitutionEntity> institutions = new ArrayList<>();
    
   public List<InstitutionEntity> getInstitution() {
        return institutions;
    }

    public void setInstitution(List<InstitutionEntity> institution) {
        this.institutions = institution;
    }
   
    public List<ProductEntity> getProducts() {
        return products;
    }
    

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
}
