package com.specialty.administrator.beans;

/**
 * Created by 陈彬 on 2018/1/10.
 */

public class Order {
    private int id ;
    private Integer images;
    private String name;
    private String money;
    private String num;
    private String total;
    private int status;// 状态判断,0:待付款,1:待发货,2:待收货,3:待评价

    public Order(int id, Integer images, String name, String money, String num, int status,String total) {
        this.id = id;
        this.images = images;
        this.name = name;
        this.money = money;
        this.num = num;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getImages() {
        return images;
    }

    public void setImages(Integer images) {
        this.images = images;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
