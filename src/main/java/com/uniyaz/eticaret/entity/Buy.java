package com.uniyaz.eticaret.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Buy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyID;

    @ManyToOne
    @JoinColumn(name = "shopUserId")
    @org.hibernate.annotations.ForeignKey(name = "fk_buy_shopuser")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShopUser shopUser;


    @Override
    public Long getId() {
        return buyID;
    }

    public ShopUser getShopUser() {
        return shopUser;
    }

    public void setBuyID(Long buyID) {
        this.buyID = buyID;
    }

    public void setShopUser(ShopUser shopUser) {
        this.shopUser = shopUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buy buy = (Buy) o;
        return Objects.equals(buyID, buy.buyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(  buyID);
    }
}
