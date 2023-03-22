package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.entity.Buy;
import com.uniyaz.eticaret.repo.BuyRepo;
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

    public Buy saveBuyList(Buy buy){

        Buy savedBuy = buyRepo.save(buy);
        return savedBuy;
    }

}
