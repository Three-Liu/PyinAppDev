package com.pinyin.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.pinyin.liusirui.pyinappdev.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouponFragment extends Fragment {


    public CouponFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon, container, false);
        WebView webView = (WebView)view.findViewById(R.id.web_page);
        webView.loadUrl("http://www.wangluogo.com");
        return view;
    }

}
