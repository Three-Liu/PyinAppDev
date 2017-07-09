package com.pinyin.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.CouponItem;
import com.pinyin.model.MsgItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by liu on 2017/7/3.
 */

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.CouponViewHolder> {
    private List<CouponItem> data;
    private LayoutInflater inflater;
    private PopupWindow mPopupWindow;
    private Context c;
    private CouponAdapter.ItemClickCallback itemClickCallback;

    //activity get data from list

    public interface ItemClickCallback {
        //clicked on the item
        void onItemClick(int p);

        //clicked on the icon
        void onIconClick(int p);
    }

    public void setItemClickCallback(final CouponAdapter.ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public CouponAdapter(Context c, List<CouponItem> list) {
        this.c = c;
        this.inflater = LayoutInflater.from(c);
        this.data = list;
    }

    @Override
    public CouponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.coupon_item, parent, false);
        return new CouponViewHolder(view);
    }

    //binding data

    @Override
    public void onBindViewHolder(CouponViewHolder holder, int position) {
        CouponItem item = data.get(position);


        //seperate color online offline
        if (item.isType()) {
            //online
            holder.cardView.setBackgroundResource(R.color.colorBackground);
            holder.relativeLayout.setBackgroundResource(R.color.colorBackground);
            holder.discount.setTextColor(Color.parseColor("#78c7f2"));
            holder.catagory.setTextColor(Color.parseColor("#78c7f2"));
            holder.mark.setTextColor(Color.parseColor("#78c7f2"));
            holder.showPop.setBackgroundResource(R.mipmap.ic_more_horiz_blue);
        } else {
            holder.cardView.setBackgroundResource(R.color.colorPrimaryDark);
            holder.relativeLayout.setBackgroundResource(R.color.colorPrimaryDark);
            holder.discount.setTextColor(Color.parseColor("#ffffff"));
            holder.catagory.setTextColor(Color.parseColor("#ffffff"));
            holder.mark.setTextColor(Color.parseColor("#ffffff"));
            holder.showPop.setBackgroundResource(R.mipmap.ic_more_horiz);
        }

        //bind data
        holder.catagory.setText(item.getCatagory());
        holder.discount.setText(item.getDiscount() + "");
        holder.head.setImageResource(item.getHead());
        holder.name.setText(item.getName());
        holder.address.setText(item.getAddress());
        holder.time.setText(item.getTime());
        holder.number.setText(item.getNumber() + "");
        holder.requirement.setText(item.getRequirement());
        holder.get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CouponViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //distinguish online offline
        CardView cardView;
        RelativeLayout relativeLayout;
        TextView discount, catagory, mark;
        Button showPop; //tintBackground

        //popWindowLayout
        ImageView head;
        TextView name, address, requirement, time, number;
        Button get; //get a coupon
        View temp;

        public CouponViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.item_container);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.coupon_content);
            discount = (TextView) itemView.findViewById(R.id.discount_value);
            catagory = (TextView) itemView.findViewById(R.id.good_catagory);
            mark = (TextView) itemView.findViewById(R.id.discount_value_mark);
            showPop = (Button) itemView.findViewById(R.id.detail_btn);
            showPop.setOnClickListener(this);
            //setPopWindow R
            temp = getPopupWindowContentView(c);
            head = (ImageView) temp.findViewById(R.id.coupon_shop_head);
            name = (TextView) temp.findViewById(R.id.coupon_shop_name);
            address = (TextView) temp.findViewById(R.id.coupon_shop_address);
            requirement = (TextView) temp.findViewById(R.id.coupon_requirement);
            time = (TextView) temp.findViewById(R.id.coupon_time);
            number = (TextView) temp.findViewById(R.id.coupon_num);
            get = (Button) temp.findViewById(R.id.get_btn);
        }

        @Override
        public void onClick(View view) {
            int clicked = view.getId();
            showPopWindow(view, temp);
        }
    }

    //popwindows

    private void showPopWindow(View view, View contentView) {
        mPopupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        int windowPos[] = PopupWindowUtil.calculatePopWindowPos(view, contentView);
        int xOff = 20;
        windowPos[0] -= xOff;
        mPopupWindow.showAtLocation(view, Gravity.TOP | Gravity.START, windowPos[0], windowPos[1]);
    }

    private View getPopupWindowContentView(Context context) {
        // findViewBy
        int layoutId = R.layout.coupon_item_drop;   // 布局ID
        View contentView = LayoutInflater.from(context).inflate(layoutId, null);
        View.OnClickListener menuItemOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Click " + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                }
            }
        };
        return contentView;
    }

}
