package com.pinyin.model;

/**
 * Created by Liusirui on 2017/3/9.
 */

public class MsgItem {
    private int itemIcon;
    private String title;
    private String verify;
    private String subTitle;
    private String msgNotice;

    public MsgItem(int itemIcon, String title, String verify, String subTitle, String msgNotice) {
        this.itemIcon = itemIcon;
        this.title = title;
        this.verify = verify;
        this.subTitle = subTitle;
        this.msgNotice = msgNotice;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getMsgNotice() {
        return msgNotice;
    }

    public void setMsgNotice(String msgNotice) {
        this.msgNotice = msgNotice;
    }
}
