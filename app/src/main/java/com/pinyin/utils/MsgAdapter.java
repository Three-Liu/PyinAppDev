package com.pinyin.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MsgItem;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Liusirui on 2017/3/9.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder>{
    private List<MsgItem> data;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    //activity get data from list

    public interface ItemClickCallback {
        //clicked on the item
        void onItemClick(int p);
        //clicked on the icon
        void onIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public MsgAdapter(Context c,List <MsgItem> list){
        this.inflater = LayoutInflater.from(c);
        this.data = list;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.msg_list_item,parent,false);
        return new MsgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {
        MsgItem item = data.get(position);
        holder.icon.setImageResource(item.getItemIcon());
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());

        if(!item.getVerify().equals("0"))
            holder.verify.setVisibility(View.INVISIBLE);
        else
            holder.verify.setVisibility(View.VISIBLE);

        if(item.getMsgNotice().equals("0"))
            holder.msgNotice.setVisibility(View.INVISIBLE);
        else {
            holder.msgNotice.setVisibility(View.VISIBLE);
            holder.msgNotice.setText(item.getMsgNotice());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MsgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title,subTitle,verify,msgNotice;
        CircleImageView icon;
        RelativeLayout relativeLayout;
        public MsgViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.msg_item_title);
            subTitle = (TextView)itemView.findViewById(R.id.msg_item_subtitle);
            verify = (TextView) itemView.findViewById(R.id.msg_item_verify);
            msgNotice = (TextView)itemView.findViewById(R.id.msg_item_massage_notice);
            icon = (CircleImageView)itemView.findViewById(R.id.msg_item_icon);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.msg_item_container);

            relativeLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clicked = view.getId();
            if(clicked == R.id.msg_item_container){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }

}
