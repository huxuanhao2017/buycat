package com.hxh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by huxuanhao on 2017-05-20.
 */
@Entity
@Table(name="buyer_cat")
public class BuyerCart {
    @Id
    @Column(name="userId")
    private String userId;
    @OneToMany(mappedBy = "buyerCart")
    private List<BuyerItem> items;
    @Column(name="totalPrice")
    private double totalPrice;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<BuyerItem> getItems() {
        return items;
    }

    public void setItems(List<BuyerItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BuyerCart{" +
                "userId='" + userId + '\'' +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public void addItem(BuyerItem item,List<BuyerItem> items){
                 //判断是否包含同款
                if (items.contains(item)) {
                         //追加数量
                        for (BuyerItem buyerItem : items) {
                               if (buyerItem.equals(item)) {
                                         buyerItem.setNum(item.getNum() + buyerItem.getNum());
                                   }
                            }
                     }else {
                         items.add(item);
                     }

             }
}
