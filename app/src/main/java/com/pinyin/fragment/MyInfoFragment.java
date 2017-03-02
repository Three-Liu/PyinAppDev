package com.pinyin.fragment;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinyin.liusirui.pyinappdev.R;
import com.pinyin.utils.FastBlurUtil;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyInfoFragment extends Fragment {
    private ImageView imageView;
    private CircleImageView circleImageView;
    public MyInfoFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_info, container, false);
        //set title
        TextView textView = (TextView)getActivity().findViewById(R.id.title);
        textView.setText("我的");
        int scaleRatio = 20;
        int blurRadius = 8;
        //mipmap to bitmap and aero glass
        BitmapDrawable originDrawable = (BitmapDrawable)getResources().getDrawable(R.mipmap.test);
        Bitmap originBitmap = originDrawable.getBitmap();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originBitmap,
                originBitmap.getWidth() / scaleRatio,
                originBitmap.getHeight() / scaleRatio,
                false);
        Bitmap blurBitmap = FastBlurUtil.doBlur(scaledBitmap, blurRadius, true);

        imageView = (ImageView)view.findViewById(R.id.profile_image_bg);
        circleImageView = (CircleImageView)view.findViewById(R.id.profile_image);
        //set image
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(blurBitmap);
        circleImageView.setImageBitmap(originBitmap);
        return view;
    }

}
