package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;


import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.SuspendScrollView;

public class SuspendScrollViewActivity extends ActionBarActivity implements SuspendScrollView.OnScrollYListener {

    private SuspendScrollView suspendScrollView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend_scroll_view);
        suspendScrollView = (SuspendScrollView) findViewById(R.id.activity_suspend_acroll_scrollview);
        linearLayout = (LinearLayout)findViewById(R.id.suspen_scroll_include);
        suspendScrollView.setonScrollYListener(this);


    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        int top = linearLayout.getTop();
        Log.e("距离", top +"");
        super.onWindowFocusChanged(hasFocus);
    }
    @Override
    public void scaleYListener(float a) {
        Log.e("滚动了多少", a + "");
    }
}
