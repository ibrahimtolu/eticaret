package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.service.UserControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserControlService userControlService;


    @PostMapping(path = "/control/")
    ResponseEntity loginControl(@RequestBody User user) {

        String userName = user.getUsername();
        String userPassword = user.getUserPassword();

        Optional<UserConverter> reUser = userControlService.findUser(userName, userPassword);

        System.out.println(reUser);

        if (reUser != null) {
            ResponseEntity responseEntity = new ResponseEntity(reUser, HttpStatus.ACCEPTED);
            return responseEntity;
        }
        ResponseEntity responseEntity = new ResponseEntity(false, HttpStatus.BAD_GATEWAY);
        return responseEntity;
    }

    @PostMapping(path = "/newuser/")
    ResponseEntity addNewUSer(@RequestBody User user) {


        boolean status = userControlService.addNewUser(user);


        if (status) {
            ResponseEntity responseEntity = new ResponseEntity(status, HttpStatus.ACCEPTED);
            return responseEntity;
        } else {
            ResponseEntity responseEntity = new ResponseEntity(status, HttpStatus.BAD_GATEWAY);
            return responseEntity;
        }
    }
    @GetMapping(path = "/getall")
    ResponseEntity getAllUser(){

       List<User> allUser = userControlService.getAllUser();


        return new ResponseEntity(allUser,HttpStatus.ACCEPTED);
    }

}