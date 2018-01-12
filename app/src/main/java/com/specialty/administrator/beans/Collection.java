package com.specialty.administrator.beans;

/**
 * Created by 陈彬 on 2018/1/8.
 */

public class Collection {
    private int id ;
    private Integer image;
    private String name ;
    private String money;

    public Collection(int id, Integer image, String name, String money) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
