package com.example.administrator.myui.activity;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.administrator.myui.R;

/**
 * 右拉小控件
 * Created by C.jiuxu on 2015/6/23.
 */
public class MovePlayerRightActivity extends ActionBarActivity {
    private View bt;
    private View ll;
    private int width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_player_right);
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        ll = findViewById(R.id.activity_move_player_right_ll);
        bt = findViewById(R.id.activity_move_player_right_tv);
        bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getRawX();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        moveViewWithFinger(x);
                        break;
                    case MotionEvent.ACTION_UP:
                        float a = width - x;
                        if (a >= 240) {
                            while (a <= 350) {
                                a++;
                                moveViewWithFinger(a);
                            }
                        } else {
                            while (a > 96) {
                                a--;
                                moveViewWithFinger(a);
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }

    private void moveViewWithFinger(float rawX) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ll
                .getLayoutParams();
        int a = (int) (width - rawX);
        if (a < 96) {
            a = 96;
        }
        if (a > 350) {
            a = 350;
        }
        params.leftMargin = -a;
        ll.setLayoutParams(params);
    }
}
