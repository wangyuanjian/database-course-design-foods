package com.hfut.edu.databasecoursedesignfoods.domain;

import java.io.Serializable;

public class Area implements Serializable {
    private Integer id;
    private String areaName;

    public Area() {
    }

    public Area(Integer id, String areaName) {
        this.id = id;
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
