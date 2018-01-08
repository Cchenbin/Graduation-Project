package com.specialty.administrator.beans;

/**
 * Created by Administrator on 2017/12/26.
 */

public class Cart {
    private String id;
    private Integer img;
    private String name;
    private String taste;
    private int num;
    private double money;
    private  int isSelected;//0,未选中，1选中


    public Cart(String id ,Integer img, String name, String taste, int num, double money,int isSelected) {
        this.id=id;
        this.img = img;
        this.name = name;
        this.taste = taste;
        this.num = num;
        this.money = money;
        this.isSelected = isSelected;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImg() {
        return img;
    }
    public void setImg(Integer img){
        this.img=img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }

    public int getIsSelected() {
        return isSelected;
    }
}
