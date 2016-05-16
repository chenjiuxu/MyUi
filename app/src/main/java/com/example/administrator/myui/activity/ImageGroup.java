package com.example.administrator.myui.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.HackyViewPager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * 多图滑动手势放大
 * Created by C.jiuxu on 2015/6/2.
 */
public class ImageGroup extends AppCompatActivity {

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
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型
                        //.decodingOptions(BitmapFactory.Options decodingOptions)//设置图片的解码配置
                .delayBeforeLoading(0)//int delayInMillis为你设置的下载前的延迟时间
                        //.preProcessor(BitmapProcessor preProcessor)  设置图片加入缓存前，对bitmap进行设置
                .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                        // .displayer(new RoundedBitmapDisplayer(20))//不推荐用！！！！是否设置为圆角，弧度为多少 会过多暂用内存
                .displayer(new FadeInBitmapDisplayer(300))//是否图片加载好后渐入的动画时间，可能会出现闪动
                .build();//构建完成
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
