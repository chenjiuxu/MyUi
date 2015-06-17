package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.SuspendScrollView;

/**
 * 悬浮ScrollView
 * Created by C.jiuxu on 2015/6/2.
 */
public class SuspendScrollViewActivity extends ActionBarActivity implements SuspendScrollView.OnScrollYListener {

    private SuspendScrollView suspendScrollView;
    private LinearLayout linearLayout;
    private int top;
    private boolean tag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend_scroll_view);
        suspendScrollView = (SuspendScrollView) findViewById(R.id.activity_suspend_acroll_scrollview);
        linearLayout = (LinearLayout) findViewById(R.id.suspen_scroll_include);
        suspendScrollView.setonScrollYListener(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        top = linearLayout.getTop();
        Log.e("距离", top + "");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void scaleYListener(float a) {

        if (a >= top) {
            if (tag) {
                tag = false;
                Toast.makeText(this, "呵呵呵", Toast.LENGTH_SHORT).show();
            }
        }
        if (a < top) {
            tag = true;

        }

        Log.e("滚动了多少", a + "" + tag);
    }
}
