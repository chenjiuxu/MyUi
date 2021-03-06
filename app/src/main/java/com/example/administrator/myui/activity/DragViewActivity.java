package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.myui.R;

/**
 * 随意拖动view
 * Created by C.jiuxu on 2015/6/17.
 */
public class DragViewActivity extends AppCompatActivity {

    private View drag_bt;
    private int[] position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_view);
        position = new int[2];
        drag_bt = findViewById(R.id.activity_drag_bt);
        drag_bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getRawX();//获得整个屏幕的坐标点
                float y = motionEvent.getRawY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        moveViewWithFinger(view, x, y);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });
    }

    private void moveViewWithFinger(View view, float rawX, float rawY) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view
                .getLayoutParams();
        params.leftMargin = (int) rawX - drag_bt.getWidth() / 2;
        params.topMargin = (int) rawY - 48 - drag_bt.getHeight() / 2;
        view.setLayoutParams(params);
    }
}
