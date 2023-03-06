package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.repo.BuyRepo;
import com.uniyaz.eticaret.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyService {

    @Autowired
    BuyRepo buyRepo;

    static int i=0;
    BuyService(){
        i++;

    }

    public Buy saveBuyList(ShopUser shopUser){

        Buy buy=new Buy();
        buy.setShopUser(shopUser);
        buy.setBuyID(new Long(i));
        Buy savedBuy = buyRepo.save(buy);
        return savedBuy;
    }

}
