package com.uniyaz.eticaret.repo;

import com.uniyaz.eticaret.converter.ShopUserConverter;
import com.uniyaz.eticaret.entity.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopUserRepo extends JpaRepository<ShopUser, Long> {

    @Query("select shopUser.product as product, shopUser.shopAmount as shopAmount  from ShopUser shopUser" +
            " left join shopUser.product products  where shopUser.user.userId=:userId")
    List<ShopUserConverter> findAllShopUserById(@Param("userId") Long userId);

    //update shop_user s set s.shop_amount =4 where  s.id =4
    @Query("update ShopUser  set  shopAmount =:amount where  shopUserId =:shopUserId ")
    void updateAmountByShopUserId(@Param("amount") int amount, @Param("shopUserId") Long shopUserId);


}
