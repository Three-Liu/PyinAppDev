package com.pinyin.ui.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pinyin.liusirui.pyinappdev.R;

public class PassResetActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("重置密码");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassResetActivity.this,MainActivity.class));
            }
        });
    }
}
