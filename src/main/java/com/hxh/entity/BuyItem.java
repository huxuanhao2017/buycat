package com.hxh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huxuanhao on 2017-05-20.
 */
@Entity
@Table(name="buyer_item")
public class BuyItem {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="status")
    private boolean isHave;
    @Column(name="num")
    private Integer num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHave() {
        return isHave;
    }

    public void setHave(boolean have) {
        isHave = have;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BuyItem{" +
                "id=" + id +
                ", isHave=" + isHave +
                ", num=" + num +
                '}';
    }
}
