package com.example.administrator.myui.fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.myui.R;
import com.example.administrator.myui.activity.DeleteListViewMainActivity;
import com.example.administrator.myui.activity.DragViewActivity;
import com.example.administrator.myui.activity.ImageCarousel;
import com.example.administrator.myui.activity.ImageGroup;
import com.example.administrator.myui.activity.ImageShape;
import com.example.administrator.myui.activity.SlideButtonActivity;
import com.example.administrator.myui.activity.SuspendScrollViewActivity;

public class ViewFragment extends Fragment implements View.OnClickListener {

    private View image_bt1;
    private View image_bt2;
    private View image_bt3;
    private View image_bt4;
    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        activity = getActivity();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        image_bt1 = view.findViewById(R.id.fragment_view_bt1);
        image_bt2 = view.findViewById(R.id.fragment_view_bt2);
        image_bt3 = view.findViewById(R.id.fragment_view_bt3);
        image_bt4 = view.findViewById(R.id.fragment_view_bt4);

        image_bt1.setOnClickListener(this);
        image_bt2.setOnClickListener(this);
        image_bt3.setOnClickListener(this);
        image_bt4.setOnClickListener(this);
        return view ;


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.fragment_view_bt1:
                intent = new Intent(activity, DeleteListViewMainActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_view_bt2:
                intent = new Intent(activity, DragViewActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_view_bt3:
                intent = new Intent(activity, SlideButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_view_bt4:
                intent = new Intent(activity, SuspendScrollViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
