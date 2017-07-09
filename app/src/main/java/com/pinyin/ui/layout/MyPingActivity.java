package com.pinyin.ui.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MyItem;
import com.pinyin.utils.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPingActivity extends AppCompatActivity implements MyAdapter.ItemClickCallback {
    private TextView toolbar_title,empty_hint;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<MyItem> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ping);
        dataInital();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        empty_hint = (TextView)findViewById(R.id.empty_hint);

        toolbar_title.setText("我拼过的");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        empty_hint.setText("快去拼in吧~");
        FrameLayout empty = (FrameLayout) findViewById(R.id.empty);
        if (data.size() == 0) {
            empty.setVisibility(View.VISIBLE);
        } else {
            empty.setVisibility(View.INVISIBLE);

            recyclerView = (RecyclerView) findViewById(R.id.my_ping_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            MyAdapter myAdapter = new MyAdapter(this, data);
            myAdapter.setItemClickCallback(this);
            recyclerView.setAdapter(myAdapter);
        }
    }

    private void dataInital() {
        data = new ArrayList<>();
        //if no data then show
        //....
    }

    @Override
    public void onItemClick(int p) {
        startActivity(new Intent(getApplicationContext(), BroadDetailActivity.class));
    }
}
