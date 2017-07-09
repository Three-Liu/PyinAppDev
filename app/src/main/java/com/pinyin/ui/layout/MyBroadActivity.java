package com.pinyin.ui.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MainItem;
import com.pinyin.model.MyItem;
import com.pinyin.utils.MainAdapter;
import com.pinyin.utils.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyBroadActivity extends AppCompatActivity implements MyAdapter.ItemClickCallback {
    private TextView toolbar_title,empty_hint;
    private Toolbar toolbar;
    private Button broadcase;
    private RecyclerView recyclerView;
    private List<MyItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broad);
        dataInital();
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
        LinearLayout empty = (LinearLayout) findViewById(R.id.empty);
        if (data.size() == 0) {
            empty.setVisibility(View.VISIBLE);
        } else {
            empty.setVisibility(View.INVISIBLE);
            recyclerView = (RecyclerView) findViewById(R.id.my_broad_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            MyAdapter myAdapter = new MyAdapter(this, data);
            myAdapter.setItemClickCallback(this);
            recyclerView.setAdapter(myAdapter);
        }

    }

    private void dataInital() {
        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(new MyItem(R.mipmap.head, R.mipmap.head, R.mipmap.person_sex_male, "Apple", "20min",
                    "Apple Headquarter", "I wonna quit!!!", true, true, "3", "40$", true));
            data.add(new MyItem(R.mipmap.head, R.mipmap.head, R.mipmap.person_sex_female, "Apple", "20min",
                    "Apple Headquarter", "I wonna quit!!!", false, true, "5", "14$", true));
            data.add(new MyItem(R.mipmap.head, R.mipmap.head, R.mipmap.person_sex_male, "Apple", "20min",
                    "Apple Headquarter", "I wonna quit!!!", true, false, "250$", "", false));
            data.add(new MyItem(R.mipmap.head, R.mipmap.head, R.mipmap.person_sex_female, "Apple", "20min",
                    "Apple Headquarter", "I wonna quit!!!", false, false, "128$", "", true));
        }
    }

    @Override
    public void onItemClick(int p) {
        startActivity(new Intent(getApplicationContext(), BroadDetailActivity.class));
    }
}
