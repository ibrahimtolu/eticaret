package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginControlService {

    @Autowired
    UserRepo userRepo;

    public Optional<UserConverter> findUser(String userName,String userPassword){
        Optional<UserConverter> getUser = userRepo.findByUserNameAndUserPassword(userName,userPassword);
        return getUser;
    }
}
