package com.example.administrator.myui.activity;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.myui.R;
import com.github.siyamed.shapeimageview.BubbleImageView;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 各种imageview形状
 * 更多请参考 https://github.com/siyamed/android-shape-imageview
 * Created by C.jiuxu on 2015/6/2.
 */
public class ImageShape extends ActionBarActivity {

    private DisplayImageOptions optiond;
    private BubbleImageView iv1;
    private RoundedImageView iv2;
    private CircularImageView iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_shape);

        optiond = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .considerExifParams(false)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        iv1 = (BubbleImageView) findViewById(R.id.activity_image_shape_iv1);
        iv2 = (RoundedImageView) findViewById(R.id.activity_image_shape_iv2);//圆角
        iv3 = (CircularImageView) findViewById(R.id.activity_image_shape_iv3);//圆形

        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", iv1, optiond);
        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", iv2, optiond);
        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", iv3, optiond);

    }


}
