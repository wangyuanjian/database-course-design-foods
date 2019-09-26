package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 由ShopSimple类而来
 */
public class ShopWhole implements Serializable {
    private Integer id;
    private String shopName;
    private String shopNumber;
    private Integer areaId;
    private String areaName;
    private List<Food> goods;

    public ShopWhole() {
    }

    public ShopWhole(Integer id, String shopName, String shopNumber, Integer areaId, String areaName, List<Food> goods) {
        this.id = id;
        this.shopName = shopName;
        this.shopNumber = shopNumber;
        this.areaId = areaId;
        this.areaName = areaName;
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "ShopWhole{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopNumber='" + shopNumber + '\'' +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", goods=" + goods +
                '}';
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public List<Food> getGoods() {
        return goods;
    }

    public void setGoods(List<Food> goods) {
        this.goods = goods;
    }
}
