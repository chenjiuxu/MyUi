package com.example.administrator.myui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.myui.fragment.ImageFragment;
import com.example.administrator.myui.fragment.LayoutFragment;
import com.example.administrator.myui.fragment.ViewFragment;

/**
 * Created by C.jiuxu on 2015/6/2.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private DrawerLayout draerlayout;
    private int i;
    private Runnable runnable;
    private ImageFragment imageFragment;
    private LayoutFragment layoutFragment;
    private FragmentManager fragmentManager;
    private View imageBt;
    private View animationBt;
    private View viewBt;
    private View layoutBt;
    private LinearLayout container;
    private ViewFragment viewFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        sideslip();
        setfragment(0);

    }


    private void initialView() {
        viewFragment = new ViewFragment();
        imageFragment = new ImageFragment();
        layoutFragment = new LayoutFragment();
        fragmentManager = getSupportFragmentManager();

        draerlayout = (DrawerLayout) findViewById(R.id.ui_drawerlayout);

        imageBt = findViewById(R.id.bt_image);
        imageBt.setOnClickListener(this);
        animationBt = findViewById(R.id.bt_animation);
        animationBt.setOnClickListener(this);
        viewBt = findViewById(R.id.bt_view);
        viewBt.setOnClickListener(this);
        layoutBt = findViewById(R.id.bt_layout);
        layoutBt.setOnClickListener(this);


        toolbar = (Toolbar) findViewById(R.id.ui_toolbar);

    }

    /**
     * fragnent页面切换
     */
    private void setfragment(int id) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (id == 0) {
            id = R.id.bt_image;
        }
        switch (id) {
            case R.id.bt_image:
                fragmentTransaction.replace(R.id.container, imageFragment, "图片");
                break;
            case R.id.bt_animation:
                break;
            case R.id.bt_view:
                fragmentTransaction.replace(R.id.container, viewFragment, "自定义控件");
                break;
            case R.id.bt_layout:
                fragmentTransaction.replace(R.id.container, layoutFragment, "布局");
                break;
        }


        fragmentTransaction.commit();
    }

    /**
     * 计时器
     */
    private void settimer() {

        final Handler handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable, 1000);
                Toast.makeText(MainActivity.this, (i++) + "", Toast.LENGTH_SHORT).show();
            }
        };
        handler.postDelayed(runnable, 1000);

    }

    /**
     * 侧滑加 toolbar
     */
    private void sideslip() {
        setSupportActionBar(toolbar);//toolbar 替代actionbar
        toolbar.setTitle("首页");
        getSupportActionBar().setHomeButtonEnabled(true);//设置返Home可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置返回键可用

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, draerlayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toolbar.setTitle("首页");



            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toolbar.setTitle("用户中心");
            }
        };
        draerlayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public void onClick(View view) {
        setfragment(view.getId());
    }
}
