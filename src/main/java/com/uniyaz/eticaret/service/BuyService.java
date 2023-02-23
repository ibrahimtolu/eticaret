package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.dao.BuyDao;
import com.uniyaz.eticaret.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyService {

    @Autowired
    BuyDao buyDao;

    static int i=0;
    BuyService(){
        i++;

    }

    public Buy saveBuyList(ShopUser shopUser){

        Buy buy=new Buy();
        buy.setShopUser(shopUser);
        buy.setBuyID(new Long(i));
        Buy savedBuy = buyDao.save(buy);
        return savedBuy;
    }

}
