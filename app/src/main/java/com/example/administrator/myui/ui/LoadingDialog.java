package com.example.administrator.myui.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myui.R;

/**
 * 联网等待框
 * Created by C.jiuxu on 2015/6/19.
 */
public class LoadingDialog extends Dialog {
    private static final int CHANGE_TITLE_WHAT = 1;
    private static final int CHNAGE_TITLE_DELAYMILLIS = 300;//时间
    private static final int MAX_SUFFIX_NUMBER = 3;//几个
    private static final char SUFFIX = '.';//不断变化的点

    private ImageView dialogImageview;
    private TextView dialogTextview;
    private RotateAnimation mAnim;

    private Handler handler = new Handler() {
        private int num = 0;

        public void handleMessage(android.os.Message msg) {
            if (msg.what == CHANGE_TITLE_WHAT) {
                StringBuilder builder = new StringBuilder();
                if (num >= MAX_SUFFIX_NUMBER) {
                    num = 0;
                }
                num++;
                for (int i = 0; i < num; i++) {
                    builder.append(SUFFIX);
                }
                dialogTextview.setText(builder.toString());
                if (isShowing()) {
                    handler.sendEmptyMessageDelayed(CHANGE_TITLE_WHAT, CHNAGE_TITLE_DELAYMILLIS);
                } else {
                    num = 0;
                }
            }
        }
    };
    private boolean cancelable = true;


    public LoadingDialog(Context context) {
        super(context, R.style.Dialog_bocop);
        initial();
    }

    private void initial() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.loading_dialog, null);
        setContentView(view);
        dialogImageview = (ImageView) findViewById(R.id.Loading_Dialong_iv);
        dialogTextview = (TextView) findViewById(R.id.Loading_Dialong_tv);
        initAnim();
        getWindow().setWindowAnimations(R.style.DialogbocopAnimation);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelable) {
                    dismiss();//作为Loading时不调用
                }
            }
        });
    }


    /**
     * 初始化动画
     */
    private void initAnim() {
        mAnim = new RotateAnimation(360, 0, Animation.RESTART, 0.5f, Animation.RESTART, 0.5f);
        mAnim.setDuration(2000);
        mAnim.setRepeatCount(Animation.INFINITE);
        mAnim.setRepeatMode(Animation.RESTART);
        mAnim.setStartTime(Animation.START_ON_FIRST_FRAME);
    }


    @Override
    public void show() {
        dialogImageview.startAnimation(mAnim);
        handler.sendEmptyMessage(CHANGE_TITLE_WHAT);
        super.show();
    }

    @Override
    public void dismiss() {
        mAnim.cancel();
        super.dismiss();
    }

    @Override
    public void setCancelable(boolean flag) {
        cancelable = flag;
        super.setCancelable(flag);
    }

}
