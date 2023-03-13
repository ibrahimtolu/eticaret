package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.entity.Products;
import com.uniyaz.eticaret.service.AdminService;
import com.uniyaz.eticaret.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "*")
public class ProductsController {


    @Autowired
    ProductService productService;

    @Autowired
    AdminService adminService;

    @GetMapping(path = "/getAll")
    public ResponseEntity getAllProducts(){
        System.out.println("gelall geldi");
        List<Products> allProducts = productService.findAllProducts();

        if (allProducts.isEmpty()){
            ResponseEntity responseEntity=new ResponseEntity(allProducts,HttpStatus.BAD_REQUEST);
            return  responseEntity;
        }
        else{
            ResponseEntity responseEntity=new ResponseEntity(allProducts,HttpStatus.ACCEPTED);

            return responseEntity;
        }
    }

    @PostMapping(path = "/save")
    public  Products updateProduct(@RequestBody Products product){


        adminService.addProduct(product);


        return product;

    }



    @DeleteMapping(path = "/delete/{id}")
  public  boolean deleteProduct(@PathVariable Long id){

        boolean status = productService.deleteProduct(id);

        return status;
    }


}
