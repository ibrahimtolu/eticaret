package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.Buy;
import com.uniyaz.eticaret.entity.ShopUser;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.service.BuyService;
import com.uniyaz.eticaret.service.LoginControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/buy")
@CrossOrigin(origins = "*")
public class BuyController {

    @Autowired
    BuyService buyService;


    @PostMapping(path = "/saveBuy")
    ResponseEntity loginControl(@RequestBody ShopUser shopUser) {
        System.out.println(shopUser);
        Buy buy = buyService.saveBuyList(shopUser);
        if (buy == null) {
            ResponseEntity responseEntity = new ResponseEntity(buy, HttpStatus.BAD_REQUEST);
            return responseEntity;
        } else {
            ResponseEntity responseEntity = new ResponseEntity(buy, HttpStatus.ACCEPTED);
            return responseEntity;
        }
    }
}