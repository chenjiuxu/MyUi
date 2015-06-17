package com.example.administrator.myui.activity.recyclerviewadapter;

/**
 * Created by Administrator on 2015/6/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myui.R;

/**
 * 新特性用于封装item  holder 点击事件
 * Created by C.jiuxu on 2015/6/17.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public final TextView tvname;
    public final TextView tvnsex;
    private final View view;
    private final onItemClick onItemClick;
    private final onItemLongClick onItemLongClick;


    public MyViewHolder(View itemView, onItemClick onItemClick, onItemLongClick onItemLongClick) {
        super(itemView);
        this.view = itemView;
        this.onItemClick = onItemClick;
        this.onItemLongClick = onItemLongClick;
        tvname = (TextView) itemView.findViewById(R.id.activity_recycler_view_rv_tv);
        tvnsex = (TextView) itemView.findViewById(R.id.activity_recycler_view_rv_tv1);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onItemClick != null) {
            onItemClick.setonItemClick(view, getLayoutPosition());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (onItemLongClick != null) {
            onItemLongClick.setonItemLongClick(view, getLayoutPosition());
        }
        return true;
    }
}
