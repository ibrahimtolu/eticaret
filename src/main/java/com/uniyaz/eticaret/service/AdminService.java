package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.dao.ProductsDao;
import com.uniyaz.eticaret.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    ProductsDao productsDao;
    public Products addProduct(Products product){

        return productsDao.save(product);
}
}
