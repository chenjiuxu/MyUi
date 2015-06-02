package com.example.administrator.myui.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.HackyViewPager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * 多图滑动手势放大
 * Created by C.jiuxu on 2015/6/2.
 */
public class ImageGroup extends ActionBarActivity {

    private HackyViewPager viewpager;
    private ArrayList<String> arrayList;
    private DisplayImageOptions optiond;
    private Runnable runnable;
    private boolean teg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_group);
        initialview();

    }

    private void initialview() {
        viewpager = (HackyViewPager) findViewById(R.id.activity_image_group_viewpager);
        arrayList = new ArrayList<>();
        arrayList.add("http://pic.dofay.com/2015/04/23m04.jpg");
        arrayList.add("http://pic.dofay.com/2015/04/23m01.jpg");
        arrayList.add("http://pic.dofay.com/2015/04/23m02.jpg");
        arrayList.add("http://pic.dofay.com/2015/04/23m03.jpg");
        optiond = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .considerExifParams(false)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        viewpager.setAdapter(new MyAdapter());
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Toast.makeText(ImageGroup.this, "当前页面" + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            ImageLoader.getInstance().displayImage(arrayList.get(position), photoView, optiond);
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }



}
