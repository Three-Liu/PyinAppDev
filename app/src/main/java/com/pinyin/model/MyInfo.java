package com.pinyin.model;

/**
 * Created by Liusirui on 2017/3/5.
 */
public class MyInfo {
    private String item;//menu items
    private int iconRes;//icon resourceId
    private int arrowRes;//arrow resourceId

    public MyInfo(String item, int iconRes, int arrowRes) {
        this.item = item;
        this.iconRes = iconRes;
        this.arrowRes = arrowRes;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public int getArrowRes() {
        return arrowRes;
    }

    public void setArrowRes(int arrowRes) {
        this.arrowRes = arrowRes;
    }
}
