package com.hxh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huxuanhao on 2017-05-20.
 */
@Entity
@Table(name = "buyer_cat")
public class BuyCart {
    @Id
    @Column(name = "userId")
    private String userId;
    @Column(name = "totalPrice")
    private double totalPrice;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BuyCart{" +
                "userId='" + userId + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
