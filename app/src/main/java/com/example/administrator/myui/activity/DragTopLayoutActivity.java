package com.example.administrator.myui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.myui.R;
import com.example.administrator.myui.fragment.ImageFragment;
import com.example.administrator.myui.fragment.LayoutFragment;
import com.example.administrator.myui.fragment.ViewFragment;

import github.chenupt.dragtoplayout.DragTopLayout;
/**
 * 顶部下拉 DragTopLayout
 * Created by C.jiuxu on 2015/6/17.
 * */
public class DragTopLayoutActivity extends ActionBarActivity {

    private DragTopLayout dragtoplayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_top_layout);
        initialView();
        setdragtoplayout();
    }

    /**
     * 设置dragtoplayout
     */
    private void setdragtoplayout() {
        dragtoplayout.openTopView(true);
        dragtoplayout.setOverDrag(false);//设置顶部是否可托拽变大
//        dragtoplayout.setAlpha(0.4f);//透明度
    }

    /**
     * 初始化页面控件
     *
     */
    private void initialView() {
        dragtoplayout = (DragTopLayout) findViewById(R.id.activity_drag_top_layout_dragtoplayout);
        viewpager = (ViewPager) findViewById(R.id.activity_drag_top_layout_viewpager);
        viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
    }


    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
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
