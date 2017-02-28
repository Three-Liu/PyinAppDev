package com.pinyin.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.pinyin.liusirui.pyinappdev.R;

public class PassResetActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("重置密码");
    }
}
