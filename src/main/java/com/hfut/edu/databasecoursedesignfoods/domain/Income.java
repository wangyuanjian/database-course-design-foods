package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

/**
 * 这个类是为了调用存储过程用到
 * in 是输出参数
 * out 是返回参数
 */
public class Income implements Serializable {
    private Integer id;
    private Double money;

    public Income() {
    }

    public Income(Integer id, Double money) {
        this.id = id;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
