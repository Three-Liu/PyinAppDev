package com.pinyin.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MyInfo;

import java.util.List;

/**
 * Created by liusirui on 2017/4/19.
 */

public class PicAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Integer> data;

    public PicAdapter(Context c, List<Integer> data) {
        this.inflater = LayoutInflater.from(c);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder{
        private ImageView iv;
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.picture_item, null);
            holder = new ViewHolder();
            holder.iv = (ImageView)convertView.findViewById(R.id.good_pic);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv.setImageResource(data.get(position));
        return convertView;
    }
}
