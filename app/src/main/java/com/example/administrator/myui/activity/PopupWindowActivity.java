package com.example.administrator.myui.activity;

import android.app.AlertDialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.LoadingDialog;

/**
 * popupWindow Dialog  区别 dialog 不阻塞线程  Popupwindow阻塞
 * 各种弹框
 * 网等待框
 * Created by C.jiuxu on 2015/6/19.
 */
public class PopupWindowActivity extends ActionBarActivity implements View.OnClickListener {

    private View viewbt2;
    private View viewbt3;
    private int i = 0;
    private View viewbt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        initialView();
    }

    /**
     * 初始化页面控件
     */
    private void initialView() {
        findViewById(R.id.activity_popup_window_bt1).setOnClickListener(this);
        viewbt2 = findViewById(R.id.activity_popup_window_bt2);
        viewbt2.setOnClickListener(this);
        viewbt3 = findViewById(R.id.activity_popup_window_bt3);
        viewbt3.setOnClickListener(this);
        viewbt4 = findViewById(R.id.activity_popup_window_bt4);
        viewbt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.activity_popup_window_bt1://弹出自定义警告框
                popupAlertDialog();
                break;
            case R.id.activity_popup_window_bt2://弹出自定义popupeWindow
                popupeWindowScreen(viewbt2);
                break;
            case R.id.activity_popup_window_bt3://弹出自定义popupeWindow
                popupeWindowView(viewbt3);
                break;
            case R.id.activity_popup_window_bt4://弹出自定义popupeWindow
                LoadingDialog loadingDialog = new LoadingDialog(this);
                loadingDialog.show();
                break;
        }

    }

    /**
     * popupWindow在指定控件的各个方向
     *
     * @param viewbt3 指定控件
     */
    private void popupeWindowView(View viewbt3) {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_popup_window_alert_dialog2, null); //需要弹出的布局
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//指定窗口大小
        popupWindow.setFocusable(true);//设置可以获得焦点
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());// setFocusable（）和此方法 一起点击外屏幕popupewindow消失
        popupWindow.setAnimationStyle(R.style.AlertDialogAnimation);//设置进入 退出动画
        //测量view的尺寸
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);// 没有这句话是无法测量
        int popupWidth = view.getMeasuredWidth();
        int popupHeight = view.getMeasuredHeight();

        //控件在屏幕中的据对坐标
        int[] location = new int[2];
        viewbt3.getLocationOnScreen(location);
        int X = location[0];
        int Y = location[1];
        int a = Y - popupHeight;

        if (i > 3) {
            i = 0;
        }
        switch (i) {

            case 0:
                popupWindow.showAtLocation(viewbt3, Gravity.NO_GRAVITY, X, a); //控件上方
                break;
            case 1:
                popupWindow.showAsDropDown(viewbt3);// 控件下方
                break;
            case 2:
                popupWindow.showAtLocation(viewbt3, Gravity.NO_GRAVITY, X - popupWidth, Y);//控件左侧
                break;
            case 3:
                popupWindow.showAtLocation(viewbt3, Gravity.NO_GRAVITY, X + viewbt3.getWidth(), Y);//控件右侧
                break;
        }
        i++;
    }

    /**
     * 弹出popupeWindow 相对以屏幕位置S
     *
     * @param viewbt2 view控件 任意控件
     */
    private void popupeWindowScreen(View viewbt2) {

        View view = LayoutInflater.from(this).inflate(R.layout.activity_popup_window_alert_dialog, null); //需要弹出的布局
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//指定窗口大小
        popupWindow.setFocusable(true); //设置PopupWindow可获得焦点
        popupWindow.setTouchable(true); //设置PopupWindow可触摸
        popupWindow.setOutsideTouchable(true); //设置非PopupWindow区域可触摸

        popupWindow.setBackgroundDrawable(new BitmapDrawable());// setFocusable（）和此方法 一起点击外屏幕popupewindow消失
        popupWindow.setAnimationStyle(R.style.PopupAnimation);//设置进入 退出动画
        //showAtLocation 方法设置相对以屏幕位置
        popupWindow.showAtLocation(viewbt2, Gravity.BOTTOM, 0, 0);// 页面任意view  设置窗口弹出相对于屏幕的位置 X偏移 Y偏移

        view.findViewById(R.id.activity_popup_window_alert_dialog_bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    /**
     * 弹出自定义警告框
     */
    private void popupAlertDialog() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();//builder 建筑者   create建立
        alertDialog.setCanceledOnTouchOutside(false);//对话框的外面点击，是否让对话框消失 默认消失 false 不消失
        alertDialog.show();//显示对话框

        Window window = alertDialog.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);//设置当前window 用于用户交互 可以获得焦点   其他作用请百度
        window.setContentView(R.layout.activity_popup_window_alert_dialog);//设置布局文件

        window.setWindowAnimations(R.style.AlertDialogAnimation);//设置AlertDialog弹出 退出动画

        window.findViewById(R.id.activity_popup_window_alert_dialog_bt1).setOnClickListener(new View.OnClickListener() {//获得点击事件完成事物
            @Override
            public void onClick(View view) {
                Toast.makeText(PopupWindowActivity.this, "完成事物", Toast.LENGTH_SHORT).show();
            }
        });
        window.findViewById(R.id.activity_popup_window_alert_dialog_bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


    }
}
