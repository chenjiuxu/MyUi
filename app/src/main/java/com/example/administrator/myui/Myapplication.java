package com.example.administrator.myui;


import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.FIFOLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by C.jiuxu on 2015/6/1.
 */
public class Myapplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // 图像处理
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getBaseContext())
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb 磁盘缓存大小
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .memoryCache(new FIFOLimitedMemoryCache(BIND_ABOVE_CLIENT))//内存缓存策略
                .memoryCacheSize(10 * 1024 * 1024)//内存缓存大小
//                .diskCache(new UnlimitedDiscCache())
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);

    }
}
