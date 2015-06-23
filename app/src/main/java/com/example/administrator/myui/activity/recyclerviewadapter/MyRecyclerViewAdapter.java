package com.example.administrator.myui.activity.recyclerviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myui.R;

import java.util.ArrayList;

/**
 * 新的适配器 数据的加载没有连接数据库
 * Created by C.jiuxu on 2015/6/17.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final Context context;
    private final ArrayList<String> arrayList;
    private onItemClick onItemClick;
    private onItemLongClick onItemLongClick;
    private int itemCount;
    private Runnable runnable;
    private boolean tag = true;


    public MyRecyclerViewAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//  第二个参数 为item的类型
        View view = null;
        MyViewHolder myViewHolder = null;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.activity_recycler_view_rv_item, null);
                myViewHolder = new MyViewHolder(view, onItemClick, onItemLongClick);
                break;
        }

        return myViewHolder;
    }

    /**
     * tiem点击事件
     * @param onItemClick
     */
    public void setOnItemClickListener(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    /**
     * item长按点击事件
     * @param onItemLongClick
     */
    public void setOnItemLongClickListener(onItemLongClick onItemLongClick) {
        this.onItemLongClick = onItemLongClick;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//根据要显示的item放入数据 posotion当前加入屏幕的item
        int itemtype = getItemViewType(position);
        itemCount = getItemCount();
        switch (itemtype) {
            case 1:
                holder.tvname.setText(arrayList.get(position));
                holder.tvnsex.setText(position + "");
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {// item的类型 返回类型
        return 1;
    }

    @Override
    public int getItemCount() {//显示数据的长度
        return arrayList.size();
    }

    /**
     * 增加数据只刷新增加的
     */
    public void notifyItemRange() {
        MyRecyclerViewAdapter.this.notifyItemRangeInserted(itemCount - 1, arrayList.size() - itemCount);
    }


}


