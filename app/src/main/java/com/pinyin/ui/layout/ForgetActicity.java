package com.pinyin.ui.layout;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.pinyin.liusirui.pyinappdev.R;

public class ForgetActicity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button fetch; //send verification code
    private Button confirm; //verify phone
    private ForgetActicity.TimeCount timer;
    private LinearLayout first; //first container
    private LinearLayout second; //second container

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        first = (LinearLayout) findViewById(R.id.first_container);
        second = (LinearLayout) findViewById(R.id.second_container);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("忘记密码");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgetActicity.this, MainActivity.class));
            }
        });


        //verification code and count
        timer = new TimeCount(60000, 1000);
        fetch = (Button) findViewById(R.id.btn_fetch_msg);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
            }
        });

        //if click confirm button show second container and hide first container
        confirm = (Button) findViewById(R.id.btn_reg_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first.setVisibility(View.INVISIBLE);
                second.setVisibility(View.VISIBLE);
            }
        });
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            fetch.setClickable(false);
            fetch.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            fetch.setText("(" + millisUntilFinished / 1000 + ") 秒");
        }

        @Override
        public void onFinish() {
            fetch.setText("重新发送");
            fetch.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            fetch.setClickable(true);
        }
    }
}
