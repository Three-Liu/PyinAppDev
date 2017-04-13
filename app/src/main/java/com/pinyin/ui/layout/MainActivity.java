package com.pinyin.ui.layout;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.pinyin.model.Person;
import com.pinyin.ui.fragment.CouponFragment;
import com.pinyin.ui.fragment.HomeFragment;
import com.pinyin.ui.fragment.MsgFragment;
import com.pinyin.ui.fragment.MyInfoFragment;
import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.ui.mainnavigatetabbar.widget.MainNavigateTabBar;
import com.pinyin.utils.BitmapByteDrawable;
import com.pinyin.utils.MyApplication;

public class MainActivity extends AppCompatActivity{
    private MainNavigateTabBar navigateTabBar;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication application = (MyApplication)getApplication();
        application.setPerson(new Person("甘景洲", true, "1996-01-04", "+86 110", "北京市石景山区", "12345", getResources().getDrawable(R.mipmap.head), "甘景洲"));

        navigateTabBar = (MainNavigateTabBar) findViewById(R.id.navigateTabBar);
        //对应xml中的containerId
        navigateTabBar.setFrameLayoutId(R.id.main_container);
        //对应xml中的navigateTabTextColor
        navigateTabBar.setTabTextColor(getResources().getColor(R.color.tab_text_normal));
        //对应xml中的navigateTabSelectedTextColor
        navigateTabBar.setSelectedTabTextColor(getResources().getColor(R.color.colorPrimaryDark));

        //恢复选项状态
        navigateTabBar.onRestoreInstanceState(savedInstanceState);

        navigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_home, R.mipmap.ic_tab_bar_home_selected, R.string.tab_bar_text_home));
        navigateTabBar.addTab(CouponFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_coupon, R.mipmap.ic_tab_bar_coupon_selected, R.string.tab_bar_text_coupon));
        navigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_blank, R.mipmap.ic_blank, R.string.tab_bar_text_broadcast));
        navigateTabBar.addTab(MsgFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_msg, R.mipmap.ic_tab_bar_msg_selected, R.string.tab_bar_text_msg));
        navigateTabBar.addTab(MyInfoFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.ic_tab_bar_my_info, R.mipmap.ic_tab_bar_my_info_selected, R.string.tab_bar_text_my_info));

        //boardcast

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前选中的选项状态
        navigateTabBar.onSaveInstanceState(outState);
    }
}
