package com.example.administrator.myui.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.myui.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * ͼƬ�ֲ�
 * Created by C.jiuxu on 2015/6/2.
 */
public class ImageCarousel extends ActionBarActivity {

    private ViewPager viewpager;
    private LinearLayout linearlayout;
    private boolean teg;
    private ArrayList<String> arrayList;
    private Runnable runnable;
    private DisplayImageOptions optiond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carousel);
        initialview();
    }

    private void initialview() {
        viewpager = (ViewPager) findViewById(R.id.activity_image_carousel_viewpager);
        linearlayout = (LinearLayout) findViewById(R.id.activity_image_carousel_linearlayout);

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
                //��תʱִ��
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        settimer();
    }

    /**
     * �����ֲ�
     */
    private void settimer() {
        final Handler handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                setswitch();
                handler.postDelayed(runnable, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    /**
     * ��ѯ�ֲ�
     */
    private void setswitch() {
        int a = viewpager.getCurrentItem();//��õ�ǰ��item
        if (a == arrayList.size() - 1) {
            teg = false;
        }
        if (a == 0) {
            teg = true;
        }
        if (teg) {
            a++;
        } else {
            a--;
        }
        viewpager.setCurrentItem(a);//����viewoager��ת��aҳ��

    }
    /**
     * viewpaer������
     */
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
            ImageView imageView = new ImageView(ImageCarousel.this);
            //  imageView.setScaleType(ImageView.ScaleType.CENTER);//ͼƬģʽ
            ImageLoader.getInstance().displayImage(arrayList.get(position), imageView, optiond);
            container.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
