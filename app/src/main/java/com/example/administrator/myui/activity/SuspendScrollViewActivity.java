package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;


import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.SuspendScrollView;

public class SuspendScrollViewActivity extends ActionBarActivity implements SuspendScrollView.OnScrollYListener {

    private SuspendScrollView suspendScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend_scroll_view);

        suspendScrollView = (SuspendScrollView) findViewById(R.id.activity_suspend_acroll_scrollview);

        suspendScrollView.setonScrollYListener(this);

    }
    @Override
    public void scaleYListener(float a) {
        Log.e("滚动了多少", a + "");
    }
}
