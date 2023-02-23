package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.dao.ProductsDao;
import com.uniyaz.eticaret.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductsDao productsDao;

    public List<Products> findAllProducts() {

        return productsDao.findAll();
    }

    public boolean deleteProduct(Long id) {
        Optional<Products> byId = productsDao.findById(id);
        if(!byId.isEmpty()){
            productsDao.deleteById(id);
            return true;
        }else
            return false;
    }


}
