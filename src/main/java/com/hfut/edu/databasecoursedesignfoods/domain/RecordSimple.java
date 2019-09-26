package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

public class RecordSimple implements Serializable {
    private Integer id;
    private Integer customerId;
    private Integer shopId;
    private String shopName;
    private String time;
    // 保存所有购买食品的id
    private String order;
    private Double money;

    public RecordSimple() {
    }

    public RecordSimple(Integer id, Integer customerId, Integer shopId, String shopName, String time, String order, Double money) {
        this.id = id;
        this.customerId = customerId;
        this.shopId = shopId;
        this.shopName = shopName;
        this.time = time;
        this.order = order;
        this.money = money;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "RecordSimple{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", shopId=" + shopId +
                ", time='" + time + '\'' +
                ", order='" + order + '\'' +
                ", money=" + money +
                '}';
    }
}
