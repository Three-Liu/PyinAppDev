package com.pinyin.ui.fragment;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.CouponItem;
import com.pinyin.utils.CouponAdapter;
import com.pinyin.utils.PopupWindowUtil;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouponFragment extends Fragment {

    ArrayList<CouponItem> arrayList = new ArrayList<>();

    public CouponFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon, container, false);
        initData();
        TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText("优惠券");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.coupon_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CouponAdapter couponAdapter = new CouponAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(couponAdapter);
        return view;
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            arrayList.add(new CouponItem(true, 78, "食品", R.mipmap.head, "KFC", "Earth", "满150减",
                    "2017-11-1~2017-12-30", 24));
            arrayList.add(new CouponItem(false, 65, "日化", R.mipmap.head, "Wumei", "Jupiter", "满200减",
                    "2017-11-1~2017-12-30", 60));
        }
    }
}
