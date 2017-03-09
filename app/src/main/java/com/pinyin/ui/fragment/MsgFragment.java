package com.pinyin.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MsgItem;
import com.pinyin.utils.MsgAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends Fragment implements MsgAdapter.ItemClickCallback{
    private TextView toolbar_title;
    private RecyclerView recyclerView;
    private ArrayList<MsgItem> data;
    public MsgFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        init();
        View view =inflater.inflate(R.layout.fragment_msg, container, false);
        toolbar_title = (TextView)view.findViewById(R.id.title);
        toolbar_title.setText("消息");

        recyclerView = (RecyclerView)view.findViewById(R.id.msg_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MsgAdapter msgAdapter = new MsgAdapter(getActivity(),data);
        msgAdapter.setItemClickCallback(this);
        recyclerView.setAdapter(msgAdapter);
        return view;
    }

    @Override
    public void onItemClick(int p) {
        Toast.makeText(getActivity().getApplicationContext(),p+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onIconClick(int p) {

    }

    private void init(){
        data = new ArrayList<>();
        for(int i=0;i<6;i++){
            data.add(new MsgItem(R.mipmap.head,"客服"+i,""+i,"会话"+i,""+i));
        }
    }
}
