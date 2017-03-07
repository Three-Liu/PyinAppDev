package com.pinyin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MyInfo;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Liusirui on 2017/3/5.
 */

public class MyInfoAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<MyInfo> data;

    public MyInfoAdapter(Context c, List<MyInfo> data) {
        this.inflater = LayoutInflater.from(c);
        this.data = data;
    }

//    @Override
//    public boolean isEnabled(int position) {
//        if (data.get(position).equals("null"))
//            return false;
//        else
//            return true;
//    }

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

    //然后重写getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView icon;
        ImageView arrow;
        TextView item;
        MyInfo myInfo = data.get(position);
        if (!myInfo.getItem().equals("null")) {
            convertView = inflater.inflate(R.layout.my_info_item, null);

            icon = (ImageView) convertView.findViewById(R.id.info_list_icon);
            item = (TextView) convertView.findViewById(R.id.info_list_item);
            arrow = (ImageView) convertView.findViewById(R.id.info_list_arrow);

            icon.setImageResource(myInfo.getIconRes());
            item.setText(myInfo.getItem());
            arrow.setImageResource(myInfo.getArrowRes());
        } else {
            convertView = inflater.inflate(R.layout.my_info_divider, null);
        }
        return convertView;
    }
}
