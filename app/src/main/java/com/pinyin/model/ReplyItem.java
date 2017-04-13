package com.pinyin.model;

/**
 * Created by liusirui on 2017/4/20.
 */

public class ReplyItem {
    private String content;
    private String time;

    public ReplyItem(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }
}
