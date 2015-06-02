package com.example.administrator.myui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myui.R;
import com.example.administrator.myui.activity.ImageAn;


public class ImageFragment extends Fragment implements View.OnClickListener {


    private View image_bt1;
    private Activity activity;

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

        image_bt1.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.fragment_image_bt1:
                intent= new Intent(activity, ImageAn.class);
                startActivity(intent);
                break;
            case R.id.fragment_image_bt2:
                intent = new Intent(activity, ImageAn.class);
                startActivity(intent);

        }

    }
}
