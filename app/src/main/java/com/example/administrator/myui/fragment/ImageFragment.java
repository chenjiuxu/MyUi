package com.example.administrator.myui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myui.R;
import com.example.administrator.myui.activity.ImageAn;
import com.example.administrator.myui.activity.ImageCarousel;
import com.example.administrator.myui.activity.ImageGroup;
import com.example.administrator.myui.activity.ImageShape;

/**
 * 图片专区
 * Created by C.jiuxu on 2015/6/2.
 */
public class ImageFragment extends Fragment implements View.OnClickListener {
    private View image_bt1;
    private Activity activity;
    private View image_bt2;
    private View image_bt3;
    private View image_bt4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        image_bt1 = view.findViewById(R.id.fragment_image_bt1);
        image_bt2 = view.findViewById(R.id.fragment_image_bt2);
        image_bt3 = view.findViewById(R.id.fragment_image_bt3);
        image_bt4 = view.findViewById(R.id.fragment_image_bt4);

        image_bt1.setOnClickListener(this);
        image_bt2.setOnClickListener(this);
        image_bt3.setOnClickListener(this);
        image_bt4.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.fragment_image_bt1:
                intent = new Intent(activity, ImageAn.class);
                startActivity(intent);
                break;
            case R.id.fragment_image_bt2:
                intent = new Intent(activity, ImageGroup.class);
                startActivity(intent);
                break;
            case R.id.fragment_image_bt3:
                intent = new Intent(activity, ImageCarousel.class);
                startActivity(intent);
                break;
            case R.id.fragment_image_bt4:
                intent = new Intent(activity, ImageShape.class);
                startActivity(intent);
                break;
        }

    }
}

