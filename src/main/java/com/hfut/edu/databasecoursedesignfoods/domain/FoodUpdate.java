package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

/**
 * 用于食物更新
 */
public class FoodUpdate implements Serializable {
    private Integer shopId;
    private String goods;

    public FoodUpdate() {
    }

    public FoodUpdate(Integer shopId, String goods) {
        this.shopId = shopId;
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "FoodUpdate{" +
                "shopId=" + shopId +
                ", goods='" + goods + '\'' +
                '}';
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}
