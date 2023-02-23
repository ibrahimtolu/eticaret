package com.uniyaz.eticaret.dao;

import com.uniyaz.eticaret.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsDao extends JpaRepository<Products,Long> {

    List<Products> findAll();

    Products save(Products products);



}
