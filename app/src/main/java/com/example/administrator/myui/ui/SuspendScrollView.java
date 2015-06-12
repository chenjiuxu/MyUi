package com.example.administrator.myui.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2015/6/12.
 */
public class SuspendScrollView extends ScrollView {
    private OnScrollYListener onScrollYListener;
    private float scaleY;

    public SuspendScrollView(Context context) {
        super(context);
    }

    public SuspendScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SuspendScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldx, int oldy) {
        scaleY = this.getScrollY();
        onScrollYListener.scaleYListener(scaleY);
        super.onScrollChanged(l, t, oldx, oldy);
    }

    public void setonScrollYListener(OnScrollYListener onScaleYListener) {
        this.onScrollYListener = onScaleYListener;
    }

    public interface OnScrollYListener {
        void scaleYListener(float a);
    }


}
