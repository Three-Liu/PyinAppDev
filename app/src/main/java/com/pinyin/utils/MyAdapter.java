package com.pinyin.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MainItem;
import com.pinyin.model.MyItem;

import java.util.List;

/**
 * Created by liusirui on 2017/4/6.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {

    private LayoutInflater inflater;
    private List<MyItem> data;
    private ItemClickCallback itemClickCallback;

    public MyAdapter(Context c, List<MyItem> list) {
        this.inflater = LayoutInflater.from(c);
        this.data = list;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myholder(inflater.inflate(R.layout.my_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        MyItem item = data.get(position);
        holder.icon.setImageResource(item.getItemIcon());
        holder.head.setImageResource(item.getBroadcasterHead());
        holder.gender.setImageResource(item.getBroadcasterGender());
        holder.name.setText(item.getBroadcastName());
        holder.time.setText(item.getBroadcastTime());
        holder.position.setText(item.getBroadcastPostion());
        holder.content.setText(item.getBroadcastContent());
        if (!item.isStatus()) { //order status flase trading,true finished
            holder.status.setText("已完成");
        } else {
            holder.status.setTextColor(Color.parseColor("#78c7f2"));
            holder.status.setText("交易中");
        }
        holder.typeNum.setText(item.getShareTypeNum());
        holder.type.setText(item.getShareType());
        holder.surplus.setText(item.getShareSurplus());
        holder.surplusNum.setText(item.getShareSurplusNum());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ItemClickCallback {
        //clicked on the item
        void onItemClick(int p);
        //clicked on the head or name
//        void onInfoClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon, head, gender;
        TextView name, time, position, content, type, typeNum, surplus, surplusNum, status;
        CardView card;
        RelativeLayout info;

        public Myholder(View itemView) {
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.item_icon);
            head = (ImageView) itemView.findViewById(R.id.broadcaster_head);
            gender = (ImageView) itemView.findViewById(R.id.broadcaster_gender);

            name = (TextView) itemView.findViewById(R.id.broadcaster_name);
            time = (TextView) itemView.findViewById(R.id.broadcast_time);
            position = (TextView) itemView.findViewById(R.id.broadcast_position);
            content = (TextView) itemView.findViewById(R.id.broadcast_content);
            type = (TextView) itemView.findViewById(R.id.share_type);
            typeNum = (TextView) itemView.findViewById(R.id.share_type_num);
            surplus = (TextView) itemView.findViewById(R.id.share_surplus);
            surplusNum = (TextView) itemView.findViewById(R.id.share_surplus_num);

            card = (CardView) itemView.findViewById(R.id.main_items_container);
            info = (RelativeLayout) itemView.findViewById(R.id.person_info);
            status = (TextView) itemView.findViewById(R.id.tx_order_status);

            card.setOnClickListener(this);
            info.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clicked = v.getId();
            switch (clicked) {
                case R.id.main_items_container:
                    itemClickCallback.onItemClick(getAdapterPosition());
                    break;
//                case R.id.person_info:
//                    itemClickCallback.onInfoClick(getAdapterPosition());
//                    break;
            }
        }
    }
}
