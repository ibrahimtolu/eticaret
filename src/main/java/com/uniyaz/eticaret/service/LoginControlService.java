package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.dao.UserDao;
import com.uniyaz.eticaret.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginControlService {

    @Autowired
    UserDao userDao;

    public Optional<UserConverter> findUser(String userName,String userPassword){
        Optional<UserConverter> getUser = userDao.findByUserNameAndUserPassword(userName,userPassword);
        return getUser;
    }
}
