package com.example.administrator.myui.activity;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.myui.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageAn extends ActionBarActivity {

    private PhotoViewAttacher photoViewAttacher;
    private ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_an);
        photoView = (ImageView) findViewById(R.id.activity_image_photoview);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .considerExifParams(false)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", photoView,options);
    }
    


}
