package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer id;
    private String customerName;
    private String password;

    public Customer() {
    }

    public Customer(Integer id, String customerName, String password) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
