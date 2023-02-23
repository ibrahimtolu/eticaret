package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.dao.ShopUserDao;
import com.uniyaz.eticaret.entity.Products;
import com.uniyaz.eticaret.entity.ShopUser;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    ShopUserDao shopUserDao;

    public List<ShopUser> findAllShopUserById(Long id) {
        List<ShopUser> allShopUser = shopUserDao.findAllShopUserById(id);
        return allShopUser;
    }

    public void saveShopProduct(Products products){

        UserType userType=new UserType();
        userType.setUserTypeId(1L);

        User user=new User();
        user.setUserId(1L);
        user.setUserTypeId(userType);

        ShopUser shopUser=new ShopUser();

        shopUser.setProduct(products);
        shopUser.setUser(user);

        shopUserDao.save(shopUser);

    }


    public boolean deleteShopProduct(Long shopUserId){
        shopUserDao.deleteById(shopUserId);

        Optional<ShopUser> byShopUserId = findByShopUserId(shopUserId);

        if (byShopUserId.isEmpty()) return true;

        return false;

    }

    public Optional<ShopUser> findByShopUserId(Long id){
        Optional<ShopUser> shopUserDaoById = shopUserDao.findById(id);
        return shopUserDaoById;
    }

    public void amountOption(int amount) {
        //shopUserDao.amountOption(amount);
    }
}
