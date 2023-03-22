package com.uniyaz.eticaret.controller;


import com.uniyaz.eticaret.auth.AuthenticationRequest;
import com.uniyaz.eticaret.auth.AuthenticationResponse;
import com.uniyaz.eticaret.auth.AuthenticationService;
import com.uniyaz.eticaret.auth.RegisterRequest;
import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.service.UserControlService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationControl {

    private final AuthenticationService authenticationService;

    @Autowired
    private UserControlService userControlService;


    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse>  register(@RequestBody RegisterRequest request){

        ResponseEntity<AuthenticationResponse> ok = ResponseEntity.ok(authenticationService.register(request));
        return ok;

    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity authenticate(@RequestBody AuthenticationRequest request){
        AuthenticationResponse authenticate = authenticationService.authenticate(request);

        return ResponseEntity.ok(authenticate);

    }


    @PostMapping(path = "/role/{token}")
    ResponseEntity getAllUser(@PathVariable  String token){
        String role=userControlService.roleControl(token);
        return ResponseEntity.ok(role);
    }

}
