package com.pinyin.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.model.MainItem;
import com.pinyin.ui.layout.MainDetailActivity;
import com.pinyin.utils.MainAdapter;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements MainAdapter.ItemClickCallback{

    private static final long REFRESH_DELAY = 1000;
    private RecyclerView recyclerView;
    private List<MainItem> data;
    private PullToRefreshView mPullToRefreshView;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        dataInital();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.main_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainAdapter msgAdapter = new MainAdapter(getActivity(),data);
        msgAdapter.setItemClickCallback(this);
        recyclerView.setAdapter(msgAdapter);

        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.main_puller);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, REFRESH_DELAY);
            }
        });
        return view;
    }

    @Override
    public void onItemClick(int p) {
        startActivity(new Intent(getActivity(), MainDetailActivity.class));
    }

    @Override
    public void onInfoClick(int p) {
        Toast.makeText(getActivity(),"info: "+p,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonClick(int p) {
        Toast.makeText(getActivity(),"button: "+p,Toast.LENGTH_SHORT).show();
    }

    private void dataInital(){
        data = new ArrayList<>();
        for(int i=0;i<3;i++){
            data.add(new MainItem(R.mipmap.head,R.mipmap.head,R.mipmap.person_sex_male,"Apple","20min",
                    "Apple Headquarter","I wonna quit!!!",true,true,"3","40$"));
            data.add(new MainItem(R.mipmap.head,R.mipmap.head,R.mipmap.person_sex_female,"Apple","20min",
                    "Apple Headquarter","I wonna quit!!!",false,true,"5","14$"));
            data.add(new MainItem(R.mipmap.head,R.mipmap.head,R.mipmap.person_sex_male,"Apple","20min",
                    "Apple Headquarter","I wonna quit!!!",true,false,"250$",""));
            data.add(new MainItem(R.mipmap.head,R.mipmap.head,R.mipmap.person_sex_female,"Apple","20min",
                    "Apple Headquarter","I wonna quit!!!",false,false,"128$",""));
        }
    }
}
