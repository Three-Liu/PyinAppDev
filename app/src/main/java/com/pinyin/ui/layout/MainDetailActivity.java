package com.pinyin.ui.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.CommentItem;
import com.pinyin.model.ReplyItem;
import com.pinyin.ui.utils.HeightResize;
import com.pinyin.utils.CommentAdapter;
import com.pinyin.utils.PicAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainDetailActivity extends AppCompatActivity {
    private ListView picture,comment;
    private List<Integer> data;
    private List<CommentItem> item;
    private Toolbar toolbar;
    private TextView toolbarText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);
        initalData();
        toolbarText = (TextView)findViewById(R.id.toolbar_title);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbarText.setText("拼单详情");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        picture = (ListView)findViewById(R.id.pic_list);
        picture.setAdapter(new PicAdapter(this,data));
        picture.setFocusable(false);


        comment = (ListView)findViewById(R.id.comment);
        comment.setAdapter(new CommentAdapter(this,item));
        comment.setFocusable(false);

        HeightResize.setListViewHeightBasedOnChildren(picture);
        HeightResize.setListViewHeightBasedOnChildren(comment);

        button = (Button)findViewById(R.id.buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PinActivity.class));
            }
        });
    }
    protected void initalData(){
        data = new ArrayList<>();
        item = new ArrayList<>();
        List<ReplyItem> t = new ArrayList<>();
        t.add(new ReplyItem("Ok","20min"));
        t.add(new ReplyItem("Ok","20min"));
        for(int i=0;i<2;i++){
            data.add(R.mipmap.head);
            item.add(new CommentItem(R.mipmap.head,"20min","小兄弟","发货慢",t));
        }
    }

}
