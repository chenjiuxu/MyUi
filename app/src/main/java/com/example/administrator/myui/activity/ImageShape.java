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
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

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

        iv1 = (BubbleImageView) findViewById(R.id.activity_image_shape_iv1);
        iv2 = (RoundedImageView) findViewById(R.id.activity_image_shape_iv2);//圆角
        iv3 = (CircularImageView) findViewById(R.id.activity_image_shape_iv3);//圆形

        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", iv1, optiond);
        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", iv2, optiond);
        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", iv3, optiond);

    }


}
