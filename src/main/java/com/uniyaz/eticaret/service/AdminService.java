package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.repo.ProductsRepo;
import com.uniyaz.eticaret.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    ProductsRepo productsRepo;
    public Products addProduct(Products product){

        return productsRepo.save(product);
}
}
