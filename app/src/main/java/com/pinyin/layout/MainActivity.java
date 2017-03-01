package com.pinyin.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pinyin.liusirui.pyinappdev.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this,PassResetActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                break;
        }
    }
}
