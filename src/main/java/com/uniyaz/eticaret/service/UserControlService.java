package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserControlService {


    @Autowired
   private  UserRepo userRepo;



    public Optional<UserConverter> findUser(String userName, String userPassword) {
        Optional<UserConverter> getUser = userRepo.findByUserNameAndUserPassword(userName, userPassword);
        return getUser;
    }

    public boolean addNewUser(User user) {



        return false;
    }

    public List<User> getAllUser() {

        List<User> allUser = userRepo.findAll();
        return allUser;
    }

    public String roleControl(String token) {


        String role = userRepo.findRole(token);
        return role;
    }
}
