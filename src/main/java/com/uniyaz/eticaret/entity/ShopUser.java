package com.uniyaz.eticaret.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ShopUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    @org.hibernate.annotations.ForeignKey(name = "fk_usershop_products")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "userId")
    @org.hibernate.annotations.ForeignKey(name = "fk_usershop_user")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    private int shopAmount;


    @Override
    public Long getId() {
        return id;
    }

    public void setShopUserId(Long shopUserId) {
        this.id = shopUserId;
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
