package com.pinyin.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.pinyin.utils.BitmapByteDrawable;


/**
 * Created by Liusirui on 2017/3/7.
 */

public class Person {
    private String name;
    private boolean gender; //true male false female
    private String birth;
    private String tel;
    private String address;
    private String password;
    private Bitmap head;
    private String nikname;

    public Person(String tel, String password) {
        this.nikname = tel;
        this.name = tel;
        this.tel = tel;
        this.password = password;
        this.gender = true;
        this.address = "北京";
    }

    public Person(String name, boolean gender, String birth, String tel, String address, String password, byte[] head, String nikname) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
        this.password = password;
        this.head = BitmapByteDrawable.byteArray2Bitmap(head,500,500);
        this.nikname = nikname;
    }

    public Person(String name, boolean gender, String birth, String tel, String address, String password, Drawable head, String nikname) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.tel = tel;
        this.address = address;
        this.password = password;
        this.head = BitmapByteDrawable.drawableToBitmap(head);
        this.nikname = nikname;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public Bitmap getHead() {
        return head;
    }

    public void setHead(Bitmap head) {
        this.head = head;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
