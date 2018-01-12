package com.specialty.administrator.beans;

/**
 * Created by 陈彬 on 2018/1/12.
 */

public class Address {
    private  int id;
    private int tag;
    private String name;
    private String phone;
    private String address;

    public Address(int id, int tag, String name, String phone, String address) {
        this.id = id;
        this.tag = tag;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
