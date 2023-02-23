package com.uniyaz.eticaret.controller;


import com.uniyaz.eticaret.entity.Products;
import com.uniyaz.eticaret.entity.ShopUser;
import com.uniyaz.eticaret.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shop")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping(path = "/getAll/{id}")
    public ResponseEntity getAllShopUserById(@PathVariable  Long id){
        List<ShopUser> allShop = shopService.findAllShopUserById(id);

        if (allShop.isEmpty()){
            ResponseEntity responseEntity=new ResponseEntity(allShop, HttpStatus.BAD_REQUEST);
            return  responseEntity;
        }
        else{
            ResponseEntity responseEntity=new ResponseEntity(allShop,HttpStatus.ACCEPTED);

            return responseEntity;
        }
    }

    @PostMapping(path = "/save")
    public ResponseEntity saveShopUser(@RequestBody Products products){

        shopService.saveShopProduct(products);

        ResponseEntity responseEntity=new ResponseEntity(HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping(path = "/delete/{id}")
    public  boolean deleteProduct(@PathVariable Long id){

        boolean status = shopService.deleteShopProduct(id);

        return status;
    }




}
