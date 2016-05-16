package com.example.administrator.myui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myui.R;
import com.example.administrator.myui.fragment.ImageFragment;
import com.example.administrator.myui.fragment.LayoutFragment;
import com.example.administrator.myui.fragment.ViewFragment;

/**
 * 选项卡指示
 * Created by C.jiuxu on 2015/6/17.
 */
public class FragmentCutPagerTitleStripActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private PagerTitleStrip pagertitlestrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_cut_pager_title_strip);
        initialView();
    }

    private void initialView() {
        viewpager = (ViewPager) findViewById(R.id.activity_fragment_cut_pager_title_strip_viewpager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewpager.setAdapter(new MyFragmentStatePagerAdapter(fragmentManager));
        pagertitlestrip = (PagerTitleStrip) findViewById(R.id.activity_fragment_cut_pager_title_strip_pagertitlestrip);

        viewpager.setOnTouchListener(new View.OnTouchListener() {//viewpager的滚动监听
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int a = viewpager.getScrollX();
                Log.e("viewpager滚动动监听", a + "");
                return false;
            }
        });
    }

    private class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {


        public MyFragmentStatePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ImageFragment();
                case 1:
                    return new LayoutFragment();
                case 2:
                    return new ViewFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "图片专区";
                case 1:
                    return "页面布局专区";
                case 2:
                    return "自定义View专区";
            }
            return super.getPageTitle(position);
        }
    }


}
