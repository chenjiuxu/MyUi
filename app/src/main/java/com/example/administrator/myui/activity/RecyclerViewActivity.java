package com.example.administrator.myui.activity;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myui.R;
import com.example.administrator.myui.RecycleViewCursorAdapter.BaseAbstractRecycleCursorAdapter;

import java.util.ArrayList;


/**
 * RecyclerView 替代listview
 */
public class RecyclerViewActivity extends ActionBarActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> arrayList;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        getdata();
        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view_rv);
        gridLayoutManager = new GridLayoutManager(this, 2);//这里用线性宫格显示 类似于grid view
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);//这里用线性宫格显示 类似于瀑布流
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//线型显示
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置滚动方向
        layoutManager.scrollToPosition(10);//设置打开第几个item

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapter());
    }

    private void getdata() {
        arrayList = new ArrayList<String>();
        for (int i = 0; i <= 100; i++) {
            arrayList.add("RecyclerView替代Listview");
        }
    }


    /**
     * 新的适配器
     */
    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//  第二个参数 为item的类型
            View view = null;
            switch (viewType) {
                case 1:
                    view = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.activity_recycler_view_rv_item, null);
                    break;
            }


            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            int itemtype = getItemViewType(position);
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
        public int getItemCount() {
            return arrayList.size();
        }
    }

    /**
     * CursorAdapter用于绑定数据库
     */
    private class MyCursorAdapter extends BaseAbstractRecycleCursorAdapter {
        public MyCursorAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, Cursor cursor) {

        }


    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvname;
        public final TextView tvnsex;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.activity_recycler_view_rv_tv);
            tvnsex = (TextView) itemView.findViewById(R.id.activity_recycler_view_rv_tv1);


        }
    }

}
