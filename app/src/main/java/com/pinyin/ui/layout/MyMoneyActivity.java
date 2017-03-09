package com.pinyin.ui.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.Person;
import com.pinyin.utils.MyApplication;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyMoneyActivity extends AppCompatActivity {
    private CircleImageView circleImageView;
    private TextView totalMoney,toolbar_title;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_money);

        MyApplication application = (MyApplication)getApplication();
        Person person = application.getPerson();

        circleImageView = (CircleImageView)findViewById(R.id.money_head);
        circleImageView.setImageBitmap(person.getHead());

        totalMoney = (TextView)findViewById(R.id.my_total_money);
        totalMoney.setText("0.00"+" 元");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        toolbar_title.setText("我的资产");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
