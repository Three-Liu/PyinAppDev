package com.pinyin.utils;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.CommentItem;
import com.pinyin.model.ReplyItem;
import com.pinyin.ui.layout.MainDetailActivity;
import com.pinyin.ui.utils.HeightResize;
import com.pinyin.ui.utils.MyListView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by liusirui on 2017/4/20.
 */

public class CommentAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<CommentItem> data;
    private Context c;
    public CommentAdapter(Context c, List<CommentItem> data) {
        this.data = data;
        this.c = c;
        this.inflater = LayoutInflater.from(c);
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
        private ImageView head;
        private TextView name;
        private TextView time;
        private TextView content;
        private ListView reply;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.comment_item, null);
            holder = new ViewHolder();
            holder.head = (ImageView)convertView.findViewById(R.id.comment_head);
            holder.name = (TextView)convertView.findViewById(R.id.comment_name);
            holder.time = (TextView)convertView.findViewById(R.id.comment_time);
            holder.content = (TextView)convertView.findViewById(R.id.comment_content);
            holder.reply = (ListView) convertView.findViewById(R.id.reply);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.head.setImageResource(data.get(position).getHead());
        holder.name.setText(data.get(position).getName());
        holder.time.setText(data.get(position).getTime());
        holder.content.setText(data.get(position).getContent());
        holder.reply.setAdapter(new ReplyAdapter(c,data.get(position).getReplyItems()));
        HeightResize.setListViewHeightBasedOnChildren(holder.reply);
        return convertView;
    }
}
