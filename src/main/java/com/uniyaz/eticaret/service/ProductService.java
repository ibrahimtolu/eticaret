package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.repo.ProductsRepo;
import com.uniyaz.eticaret.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductsRepo productsRepo;

    public List<Products> findAllProducts() {

        return productsRepo.findAll();
    }

    public boolean deleteProduct(Long id) {
        Optional<Products> byId = productsRepo.findById(id);
        if(!byId.isEmpty()){
            productsRepo.deleteById(id);
            return true;
        }else
            return false;
    }


}
