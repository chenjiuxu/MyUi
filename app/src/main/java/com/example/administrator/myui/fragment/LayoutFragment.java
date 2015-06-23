package com.example.administrator.myui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myui.R;
import com.example.administrator.myui.activity.DragTopLayoutActivity;
import com.example.administrator.myui.activity.FragmentCutPagerSlidingTabStripActivity;
import com.example.administrator.myui.activity.FragmentCutPagerTitleStripActivity;
import com.example.administrator.myui.activity.MovePlayerRightActivity;
import com.example.administrator.myui.activity.PopupWindowActivity;

/**
 * Created by C.jiuxu on 2015/6/2.
 */
public class LayoutFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        view.findViewById(R.id.fragment_layout_bt1).setOnClickListener(this);
        view.findViewById(R.id.fragment_layout_bt2).setOnClickListener(this);
        view.findViewById(R.id.fragment_layout_bt3).setOnClickListener(this);
        view.findViewById(R.id.fragment_layout_bt4).setOnClickListener(this);
        view.findViewById(R.id.fragment_layout_bt5).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;
        switch (id) {
            case R.id.fragment_layout_bt1:
                intent = new Intent(getActivity(), FragmentCutPagerTitleStripActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_layout_bt2:
                intent = new Intent(getActivity(), FragmentCutPagerSlidingTabStripActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_layout_bt3:
                intent = new Intent(getActivity(), DragTopLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_layout_bt4:
                intent = new Intent(getActivity(), PopupWindowActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_layout_bt5:
                intent = new Intent(getActivity(), MovePlayerRightActivity.class);
                startActivity(intent);
                break;
        }
    }
}
