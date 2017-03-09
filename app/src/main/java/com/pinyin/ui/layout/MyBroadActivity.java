package com.pinyin.ui.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;

public class MyBroadActivity extends AppCompatActivity {
    private TextView toolbar_title,empty_hint;
    private Toolbar toolbar;
    private Button broadcase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broad);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        empty_hint = (TextView)findViewById(R.id.empty_hint);

        toolbar_title.setText("我发布的");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        empty_hint.setText("还没有发布宝贝呢~");
    }
}
