package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

public class Food implements Serializable {
    private Integer id;
    private String foodName;
    private Integer categoryId;
    private String categoryName;
    private Double money;

    public Food() {
    }

    public Food(Integer id, String foodName, Integer categoryId, String categoryName, Double money) {
        this.id = id;
        this.foodName = foodName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.money = money;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", categoryId=" + categoryId +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
