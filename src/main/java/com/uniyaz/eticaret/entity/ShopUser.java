package com.uniyaz.eticaret.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class ShopUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopUserId;

    @ManyToOne
    @JoinColumn(name = "productId")
    @org.hibernate.annotations.ForeignKey(name = "fk_usershop_products")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "userId")
    @org.hibernate.annotations.ForeignKey(name = "fk_usershop_user")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    private int shopAmount;


    @Override
    public Long getId() {
        return shopUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopUser shopUser = (ShopUser) o;
        return Objects.equals(shopUserId, shopUser.shopUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopUserId);
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    public void setProduct(Products product) {
        this.product = product;
    }



    public Products getProduct() {
        return product;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getShopAmount() {
        return shopAmount;
    }

    public void setShopAmount(int shopAmount) {
        this.shopAmount = shopAmount;
    }
}
