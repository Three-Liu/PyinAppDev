package com.pinyin.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.pinyin.liusirui.pyinappdev.R;


public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btn_reg;
    private Button btn_forg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("登录");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });

    }
}
