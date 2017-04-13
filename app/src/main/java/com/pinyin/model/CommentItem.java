package com.pinyin.model;

import java.util.List;

/**
 * Created by liusirui on 2017/4/20.
 */

public class CommentItem {
    private int head;
    private String time;
    private String name;
    private String content;
    private List<ReplyItem> replyItems;

    public CommentItem(int head, String time, String name, String content, List<ReplyItem> replyItems) {
        this.head = head;
        this.time = time;
        this.name = name;
        this.content = content;
        this.replyItems = replyItems;
    }

    public int getHead() {
        return head;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public List<ReplyItem> getReplyItems() {
        return replyItems;
    }
}
