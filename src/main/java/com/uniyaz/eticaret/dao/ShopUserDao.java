package com.uniyaz.eticaret.dao;

import com.uniyaz.eticaret.entity.Products;
import com.uniyaz.eticaret.entity.ShopUser;
import com.uniyaz.eticaret.service.ShopService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopUserDao extends JpaRepository<ShopUser, Long> {

    @Query("select shopUser from ShopUser shopUser" +
            " left join shopUser.product product  where shopUser.user.userId=:userId")
    List<ShopUser> findAllShopUserById(@Param("userId") Long userId);

    @Query("select shopUser from ShopUser shopUser " +
            "left join shopUser.product product where shopUser.id=:id")
    ShopUser findByShopUserId(@Param("id") Long id);




}
