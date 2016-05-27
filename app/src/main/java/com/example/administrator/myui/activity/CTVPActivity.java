package com.example.administrator.myui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.myui.R;
import com.example.administrator.myui.fragment.ImageFragment;
import com.example.administrator.myui.fragment.LayoutFragment;
import com.example.administrator.myui.fragment.ViewFragment;

public class CTVPActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewpager;
    private Toolbar toolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctvp);
        toolbar = (Toolbar) findViewById(R.id.ctvp_toolbar);
        tabLayout = (TabLayout) findViewById(R.id.ctvp_tabs);
        viewpager = (ViewPager) findViewById(R.id.ctvp_vp);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.ctvp_toolbar_layout);
        initview();
        setData();
    }

    private void initview() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示

        mCollapsingToolbarLayout.setTitle("陈玖旭");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色

    }

    private void setData() {
        viewpager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewpager);
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
