package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.repo.ShopUserRepo;
import com.uniyaz.eticaret.entity.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopUserService {

    @Autowired
    ShopUserRepo shopUserRepo;

    public List<ShopUser> findAllShopUserById(Long id) {
        List<ShopUser> allShopUser = shopUserRepo.findAllShopUserById(id);

        return allShopUser;
    }

    public void saveShopProduct(ShopUser shopUser){


        shopUserRepo.save(shopUser);

    }


    public boolean deleteShopProduct(Long shopUserId){
        shopUserRepo.deleteById(shopUserId);

        Optional<ShopUser> byShopUserId = findByShopUserId(shopUserId);

        if (byShopUserId.isEmpty()) return true;

        return false;

    }

    public Optional<ShopUser> findByShopUserId(Long id){
        Optional<ShopUser> shopUserDaoById = shopUserRepo.findById(id);
        return shopUserDaoById;
    }

    public void updateAmountByShopUserId(ShopUser shopUser){
        ShopUser savedShopUser=new ShopUser();
        savedShopUser.setShopUserId(shopUser.getId());
        savedShopUser.setShopAmount(shopUser.getShopAmount());
        shopUserRepo.save(savedShopUser);

    }


    public void save(ShopUser shopUser) {
        shopUserRepo.save(shopUser);
    }
}
