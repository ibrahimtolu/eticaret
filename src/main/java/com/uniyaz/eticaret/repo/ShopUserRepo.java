package com.uniyaz.eticaret.repo;

import com.uniyaz.eticaret.entity.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ShopUserRepo extends JpaRepository<ShopUser, Long> {

    @Query("select shopUser from ShopUser shopUser" +
            " left join shopUser.product product  where shopUser.user.userId=:userId")
    List<ShopUser> findAllShopUserById(@Param("userId") Long userId);

    @Query("select shopUser from ShopUser shopUser " +
            "left join shopUser.product product where shopUser.id=:id")
    ShopUser findByShopUserId(@Param("id") Long id);

    //update shop_user s set s.shop_amount =4 where  s.id =4
    @Query("update ShopUser  set  shopAmount =:amount where  id =:shopUserId ")
    void updateAmountByShopUserId(@Param("amount") int amount, @Param("shopUserId") Long shopUserId);



}
