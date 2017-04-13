package com.pinyin.model;

/**
 * Created by liusirui on 2017/4/6.
 *
 * this class is used to fill main RecycleView Item
 *
 *  v0.1 a fake version of this class, next version will pass a class object to construct method
 */

public class MainItem {
    //three mipmap
    private int itemIcon;
    private int broadcasterHead;
    private int broadcasterGender;

    private String broadcastName;
    private String broadcastTime; // a percise time , after subract current time
    private String broadcastPostion;
    private String broadcastContent;

    private String shareType;//according to pin type
    private String shareTypeNum;//the rest of person / the lack of money
    private String shareSurplus;
    private String shareSurplusNum;//the number of people or

// accomplish next time

//    public MainItem(Pin p) {
//
//    }

    // fake constructor


    public MainItem(int itemIcon, int broadcasterHead, int broadcasterGender, String broadcastName, String broadcastTime, String broadcastPostion, String broadcastContent, String shareType, String shareTypeNum, String shareSurplus, String shareSurplusNum) {
        this.itemIcon = itemIcon;
        this.broadcasterHead = broadcasterHead;
        this.broadcasterGender = broadcasterGender;
        this.broadcastName = broadcastName;
        this.broadcastTime = broadcastTime;
        this.broadcastPostion = broadcastPostion;
        this.broadcastContent = broadcastContent;
        this.shareType = shareType;
        this.shareTypeNum = shareTypeNum;
        this.shareSurplus = shareSurplus;
        this.shareSurplusNum = shareSurplusNum;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public int getBroadcasterHead() {
        return broadcasterHead;
    }

    public int getBroadcasterGender() {
        return broadcasterGender;
    }

    public String getBroadcastName() {
        return broadcastName;
    }

    public String getBroadcastTime() {
        return broadcastTime;
    }

    public String getBroadcastPostion() {
        return broadcastPostion;
    }

    public String getBroadcastContent() {
        return broadcastContent;
    }

    public String getShareType() {
        return shareType;
    }

    public String getShareTypeNum() {
        return shareTypeNum;
    }

    public String getShareSurplus() {
        return shareSurplus;
    }

    public String getShareSurplusNum() {
        return shareSurplusNum;
    }
}
