package com.pinyin.model;

/**
 * Created by liu on 2017/7/3.
 */

public class CouponItem {
    //item attr
    private boolean type; //online:true  offline:false
    private float discount; //discount price
    private String catagory; //coupon catagory

    //popwindow attr
    private int head;
    private String name;
    private String address;
    private String requirement;
    private String time;  //simpledate yyyy-MM-dd
    private int number; //coupon number

    public CouponItem() {
    }

    public CouponItem(boolean type, float discount, String catagory, int head, String name, String address, String requirement, String time, int number) {
        this.type = type;
        this.discount = discount;
        this.catagory = catagory;
        this.head = head;
        this.name = name;
        this.address = address;
        this.requirement = requirement;
        this.time = time;
        this.number = number;
    }


    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
