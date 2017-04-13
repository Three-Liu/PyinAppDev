package com.pinyin.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.ReplyItem;

import java.util.List;

/**
 * Created by liusirui on 2017/4/20.
 */

public class ReplyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ReplyItem> data;
    public ReplyAdapter(Context c, List<ReplyItem> data) {
        this.data = data;
        this.inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewHolder{
        private TextView time;
        private TextView content;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.reply_item, null);
            holder = new ViewHolder();
            holder.time = (TextView)convertView.findViewById(R.id.reply_time);
            holder.content = (TextView)convertView.findViewById(R.id.reply_msg);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.time.setText(data.get(position).getTime());
        holder.content.setText(data.get(position).getContent());
        return convertView;
    }
}
