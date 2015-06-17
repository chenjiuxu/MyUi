package com.example.administrator.myui.activity;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.myui.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;


/**
 * 卡片风
 * Created by C.jiuxu on 2015/6/17.
 */
public class CardViewActivity extends ActionBarActivity {

    private CardView cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        ImageView photoView = (ImageView) findViewById(R.id.activity_card_photoview);
        cardview = (CardView) findViewById(R.id.activity_card_cardview);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
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
        ImageLoader.getInstance().displayImage("http://pic.dofay.com/2015/04/23m04.jpg", photoView, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Palette.generateAsync(loadedImage, new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        //getDarkMutedSwatch 深柔色
                        //getLightMutedSwatch 亮柔色
                        //getDarkVibrantSwatch 深色
                        Palette.Swatch vibrant = palette.getLightMutedSwatch();
                        int a = vibrant.getRgb();
                        cardview.setCardBackgroundColor(a);
                    }
                });
                Toast.makeText(CardViewActivity.this, "以运行", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });


    }


}
