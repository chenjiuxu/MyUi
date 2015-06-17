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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.myui.R;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        getdata();
        recyclerView = (RecyclerView) findViewById(R.id.activity_recycler_view_rv);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_recycler_view_sfl);//下拉刷新组件
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(RecyclerViewActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);

            }
        });
        gridLayoutManager = new GridLayoutManager(this, 2);//这里用线性宫格显示 类似于grid view
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);//这里用线性宫格显示 类似于瀑布流
        layoutManager = new LinearLayoutManager(this);//线型显示
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置滚动方向
        //       layoutManager.scrollToPosition(10);//设置打开第几个item
//        recyclerView.addItemDecoration(new MyItemDecoration(this, LinearLayoutManager.VERTICAL)); // 分割线
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setOnItemClickListener(new onItemClick() {
            @Override
            public void setonItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int a = layoutManager.findLastCompletelyVisibleItemPosition();//屏幕下方出现的item个数
//                findFirstVisibleItemPosition()
//                findFirstCompletelyVisibleItemPosition//上方
//                findLastVisibleItemPosition()
//                findLastCompletelyVisibleItemPosition()//下方
//                Log.e("滚动状态1", newState + "");
                Log.e("滚动状态2", a + "");
                if (a == arrayList.size() - 1 && tag) {
                    tag = false;
                    Toast.makeText(RecyclerViewActivity.this, "上拉加载。。。。。", Toast.LENGTH_SHORT).show();
                    tag = true;
                }
            }
        });
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
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private onItemClick onItemClick;
        private onItemLongClick onItemLongClick;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//  第二个参数 为item的类型
            View view = null;
            switch (viewType) {
                case 1:
                    view = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.activity_recycler_view_rv_item, null);
                    break;
            }
            MyViewHolder myViewHolder = new MyViewHolder(view, onItemClick, onItemLongClick);
            return myViewHolder;
        }

        public void setOnItemClickListener(onItemClick onItemClick) {
            this.onItemClick = onItemClick;
        }

        public void setOnItemLongClickListener(onItemLongClick onItemLongClick) {
            this.onItemLongClick = onItemLongClick;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {//根据要显示的item放入数据
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
        public int getItemCount() {//显示数据的长度
            return arrayList.size();
        }


    }

    /**
     * item点击事件
     */
    public abstract class onItemClick {
        public abstract void setonItemClick(View view, int position);
    }

    /**
     * item长按点击事件
     */
    public abstract class onItemLongClick {
        abstract void setonItemLongClick(View view, int position);
    }

    /**
     * 分割线
     */
    private class MyItemDecoration extends RecyclerView.ItemDecoration {


    }

    /**
     * 新特性用于封装item  holder 点击事件
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


}
