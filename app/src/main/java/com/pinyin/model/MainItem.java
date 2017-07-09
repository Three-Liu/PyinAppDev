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
    private boolean type; //person true,money false

    private boolean onOff; //online true, offline false;
    private String shareType;//according to pin type
    private String shareTypeNum;//the rest of person / the lack of money
    private String shareSurplus;
    private String shareSurplusNum;//the number of people or

// accomplish next time

    public MainItem() {

    }

    // fake constructor


    public MainItem(int itemIcon, int broadcasterHead, int broadcasterGender, String broadcastName, String broadcastTime,
                    String broadcastPostion, String broadcastContent, boolean onOff, boolean type,String shareTypeNum, String shareSurplusNum) {
        this.itemIcon = itemIcon;
        this.broadcasterHead = broadcasterHead;
        this.broadcasterGender = broadcasterGender;
        this.broadcastName = broadcastName;
        this.broadcastTime = broadcastTime;
        this.broadcastPostion = broadcastPostion;
        this.broadcastContent = broadcastContent;
        this.onOff = onOff;
        this.type = type;
        if(type) {
            this.shareType = "剩余人数： ";
            this.shareTypeNum = shareTypeNum;
            this.shareSurplus = "人均： ";
            this.shareSurplusNum = shareSurplusNum;
        }else{
            this.shareType = "剩余价格： ";
            this.shareTypeNum = shareTypeNum;
            this.shareSurplus = "";
            this.shareSurplusNum = "";
        }
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

    public boolean isOnOff() {
        return onOff;
    }
}

