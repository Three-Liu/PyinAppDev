package com.pinyin.ui.layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinyin.liusirui.pyinappdev.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomButtonFragment extends Fragment {


    public BottomButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_button, container, false);

        return view;
    }

}
