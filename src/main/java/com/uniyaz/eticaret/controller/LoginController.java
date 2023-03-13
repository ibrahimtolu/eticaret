package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.service.LoginControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginControlService loginControlService;


    @PostMapping(path = "/control/")
    ResponseEntity loginControl(@RequestBody User user){

        System.out.printf("user",user);


        String userName = user.getUserName();
        String userPassword = user.getUserPassword();

        Optional<UserConverter> reUser = loginControlService.findUser(userName,userPassword);

        System.out.println(reUser);

        if(reUser!=null){
            ResponseEntity responseEntity=new ResponseEntity(reUser,HttpStatus.ACCEPTED);
        return responseEntity;
        }
        ResponseEntity responseEntity=new ResponseEntity(false,HttpStatus.BAD_GATEWAY);
        return  responseEntity;
    }
}