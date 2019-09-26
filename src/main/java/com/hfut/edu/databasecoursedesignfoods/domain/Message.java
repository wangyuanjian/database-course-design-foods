package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

public class Message implements Serializable {
    private Integer id;
    private Integer customerId;
    private Integer shopId;
    private Integer recordId;
    private String time;
    private String content;
    private Integer customerRead;
    private Integer shopRead;

    public Message() {
    }

    public Message(Integer id, Integer customerId, Integer shopId, Integer recordId, String time, String content, Integer customerRead, Integer shopRead) {
        this.id = id;
        this.customerId = customerId;
        this.shopId = shopId;
        this.recordId = recordId;
        this.time = time;
        this.content = content;
        this.customerRead = customerRead;
        this.shopRead = shopRead;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", shopId=" + shopId +
                ", recordId=" + recordId +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", customerRead=" + customerRead +
                ", shopRead=" + shopRead +
                '}';
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

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCustomerRead() {
        return customerRead;
    }

    public void setCustomerRead(Integer customerRead) {
        this.customerRead = customerRead;
    }

    public Integer getShopRead() {
        return shopRead;
    }

    public void setShopRead(Integer shopRead) {
        this.shopRead = shopRead;
    }
}
