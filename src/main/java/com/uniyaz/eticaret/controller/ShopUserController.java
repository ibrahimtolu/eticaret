package com.uniyaz.eticaret.controller;


import com.uniyaz.eticaret.converter.ShopUserConverter;
import com.uniyaz.eticaret.entity.ShopUser;
import com.uniyaz.eticaret.service.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auth/shop")
@CrossOrigin(origins = "*")
public class ShopUserController {

    @Autowired
    ShopUserService shopService;

    @PostMapping(path = "/save")
    public ResponseEntity saveShopUser(@RequestBody ShopUser shopUser) {

        shopService.saveShopProduct(shopUser);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @GetMapping(path = "/getAll/{id}")
    public ResponseEntity getAllShopUserById(@PathVariable Long id) {
        List<ShopUserConverter> allShopUserById = shopService.findAllShopUserById(id);
        return ResponseEntity.ok(allShopUserById);
    }


    @PutMapping(path = "/save/shopuser")
    public ResponseEntity saveShopAmount(@RequestBody ShopUser shopUser) {

        shopService.save(shopUser);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteProduct(@PathVariable Long id) {

        boolean status = shopService.deleteShopProduct(id);
        return status;
    }

    @PutMapping(path = "/amount")
    public ResponseEntity updateAmountByShopUserId(@RequestBody ShopUser shopUser) {
        System.out.println(shopUser);
        shopService.updateAmountByShopUserId(shopUser);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
