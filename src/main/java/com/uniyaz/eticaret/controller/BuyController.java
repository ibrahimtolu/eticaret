package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.entity.Buy;
import com.uniyaz.eticaret.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth/buy")
@CrossOrigin(origins = "*")
public class BuyController {

    @Autowired
    BuyService buyService;


    @PostMapping(path = "/save")
    ResponseEntity loginControl(@RequestBody Buy buy) {

          buy = buyService.saveBuyList(buy);
        if (buy == null) {
            ResponseEntity responseEntity = new ResponseEntity(buy, HttpStatus.BAD_REQUEST);
            return responseEntity;
        } else {
            ResponseEntity responseEntity = new ResponseEntity(buy, HttpStatus.ACCEPTED);
            return responseEntity;
        }
    }
}