package com.pinyin.model;

/**
 * Created by liusirui on 2017/7/9.
 */

public class MyItem extends MainItem {

    private boolean status; //order status flase trading,true finished

    public MyItem() {
        super();
    }

    public MyItem(int itemIcon, int broadcasterHead, int broadcasterGender, String broadcastName, String broadcastTime, String broadcastPostion, String broadcastContent, boolean onOff, boolean type, String shareTypeNum, String shareSurplusNum, boolean status) {
        super(itemIcon, broadcasterHead, broadcasterGender, broadcastName, broadcastTime, broadcastPostion, broadcastContent, onOff, type, shareTypeNum, shareSurplusNum);
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

