package com.example.administrator.myui.activity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.example.administrator.myui.R;
import com.example.administrator.myui.fragment.ImageFragment;
import com.example.administrator.myui.fragment.LayoutFragment;
import com.example.administrator.myui.fragment.ViewFragment;

/**
 * 选项卡切换
 * Created by C.jiuxu on 2015/6/17.
 */
public class FragmentCutPagerSlidingTabStripActivity extends AppCompatActivity {

    private PagerSlidingTabStrip pagerSlidingTabStrip;
    private ViewPager viewpager;
    private LayerDrawable oldBackground;
    private int currentColor;
    private Drawable.Callback drawableCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_cut_pager_sliding_tab_strip);
        pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.activity_fragnent_cut_pager_sliding_tab_strip);
        viewpager = (ViewPager) findViewById(R.id.activity_fragnent_cut_pager_sliding_tab_strip_viewpager);
        viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        pagerSlidingTabStrip.setViewPager(viewpager);

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
    private void changeColor(int newColor) {
        pagerSlidingTabStrip.setIndicatorColor(newColor);
        setActionBarcolor(newColor);
        currentColor = newColor;

    }

    /**
     * 改变ActionBar color
     * @param newColor 颜色值
     */
    private void setActionBarcolor(int newColor) {
        // 改变ActionBar颜色如果ActionBar是可用的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Drawable colorDrawable = new ColorDrawable(newColor);
            Drawable bottomDrawable = getResources().getDrawable(R.drawable.abc_ab_share_pack_mtrl_alpha);
            LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});
            if (oldBackground == null) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    ld.setCallback(drawableCallback);
                } else {
                    getActionBar().setBackgroundDrawable(ld);
                }
            } else {
                TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
                // 解决了破碎ActionBarContainer可拉的处理
                // pre-API 17 builds
                // https://github.com/android/platform_frameworks_base/commit/a7cc06d82e45918c37429a59b14545c6a57db4e4
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    td.setCallback(drawableCallback);
                } else {
                    getActionBar().setBackgroundDrawable(td);
                }
                td.startTransition(200);
            }

        }
    }
}
