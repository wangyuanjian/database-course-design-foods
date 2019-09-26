package com.hfut.edu.databasecoursedesignfoods.domain;


import java.io.Serializable;

public class ShopSimple implements Serializable {
    private Integer id;
    private String shopName;
    private String shopNumber;
    private Integer areaId;
    private String areaName;
    // 这个goods保存所有商品的id,
    private String goods;

    public ShopSimple() {
    }

    @Override
    public String toString() {
        return "ShopSimple{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopNumber='" + shopNumber + '\'' +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", goods='" + goods + '\'' +
                '}';
    }

    public ShopSimple(Integer id, String shopName, String shopNumber, Integer areaId, String areaName, String goods) {
        this.id = id;
        this.shopName = shopName;
        this.shopNumber = shopNumber;
        this.areaId = areaId;
        this.areaName = areaName;
        this.goods = goods;
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

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

}
