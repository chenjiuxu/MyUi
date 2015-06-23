package com.example.administrator.myui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myui.R;
import com.example.administrator.myui.activity.recyclerviewadapter.MyRecyclerViewAdapter;
import com.example.administrator.myui.activity.recyclerviewadapter.onItemClick;

import java.util.ArrayList;


/**
 * RecyclerView 替代listview
 * Created by C.jiuxu on 2015/6/17.
 */
public class RecyclerViewActivity extends ActionBarActivity {
    private RecyclerView recyclerView;//理解为新的listview
    private ArrayList<String> arrayList;
    /**
     * RecyclerView的布局组件
     */
    private GridLayoutManager gridLayoutManager;//网格布局
    private StaggeredGridLayoutManager staggeredGridLayoutManager;//瀑布流
    private LinearLayoutManager layoutManager;//线型布局
    /**
     * 下拉刷新组件
     */
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean tag = true;
    private MyRecyclerViewAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initial();
        getdata();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {//下拉刷新监听
            @Override
            public void onRefresh() {
                Toast.makeText(RecyclerViewActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);

                arrayList.remove(0);
                myAdapter.notifyItemRemoved(0);

            }
        });
        setRecyclerViewManager();
        setRecyclerView();
        /**
         * 滚动事件
         * */
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int a = layoutManager.findLastCompletelyVisibleItemPosition();//屏幕下方出现的item第几个item
//                findFirstVisibleItemPosition()
//                findFirstCompletelyVisibleItemPosition//上方
//                findLastVisibleItemPosition()
//                findLastCompletelyVisibleItemPosition()//下方
//                Log.e("滚动状态1", newState + "");
                int totalItemCount = layoutManager.getItemCount() - 1;
                if (a == totalItemCount && tag) {//通知数据改变
                    tag = false;
                    for (int i = 0; i < 20; i++) {
                        arrayList.add("新数据");
                    }
                    myAdapter.notifyItemRange();
                    tag = true;
                    Toast.makeText(RecyclerViewActivity.this, "数据以更新", Toast.LENGTH_SHORT).show();
                }
                Log.e("滚动状态2", a + "");
            }
        });
    }

    /**
     * 初始化页面view
     */
    private void initial() {

        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view_rv);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_recycler_view_sfl);//下拉刷新组件


    }

    /**
     * 获得模拟数据
     */
    private void getdata() {
        if (arrayList == null) {
            arrayList = new ArrayList<String>();
        }
        for (int i = 0; i <= 20; i++) {
            arrayList.add("RecyclerView替代Listview");
        }
    }

    /**
     * RecyclerView布局Manager
     */
    private void setRecyclerViewManager() {
        gridLayoutManager = new GridLayoutManager(this, 2);//这里用线性宫格显示 类似于grid view
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);//这里用线性宫格显示 类似于瀑布流
        layoutManager = new LinearLayoutManager(this);//线型显示
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置滚动方向
    }

    /**
     * RecyclerView设置属性
     */
    private void setRecyclerView() {
//      layoutManager.scrollToPosition(10);//设置打开第几个item
//      recyclerView.addItemDecoration(new MyItemDecoration(this, LinearLayoutManager.VERTICAL)); // 分割线
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        myAdapter = new MyRecyclerViewAdapter(this, arrayList);

        myAdapter.setOnItemClickListener(new onItemClick() {//设置item点击事件
            @Override
            public void setonItemClick(View view, int position) {
                arrayList.remove(position); 
                myAdapter.notifyItemRemoved(position);
                myAdapter.notifyItemRangeChanged(position, 20);//删除后数据发生变化
                Toast.makeText(RecyclerViewActivity.this, position + "个以删除！！！！！！", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
    }

    /**
     * 分割线
     */
    private class MyItemDecoration extends RecyclerView.ItemDecoration {
    }
}
