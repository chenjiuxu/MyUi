package com.example.administrator.myui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.SimpleAdapter;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.DragGridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DragGridViewActivity extends AppCompatActivity {
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_grid_view);

        DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
        for (int i = 0; i < 30; i++) {
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image",R.drawable.meinv);
            itemHashMap.put("item_text", "��ק " + Integer.toString(i));
            dataSourceList.add(itemHashMap);
        }


        final SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, dataSourceList,
                R.layout.grid_item, new String[] { "item_image", "item_text" },
                new int[] { R.id.item_image, R.id.item_text });

        mDragGridView.setAdapter(mSimpleAdapter);

        mDragGridView.setOnChangeListener(new DragGridView.OnChanageListener() {

            @Override
            public void onChange(int from, int to) {
                HashMap<String, Object> temp = dataSourceList.get(from);
                //ֱ�ӽ���item
//				dataSourceList.set(from, dataSourceList.get(to));
//				dataSourceList.set(to, temp);


                //����Ĵ�����Ҫע����
                if (from < to) {
                    for (int i = from; i < to; i++) {
                        Collections.swap(dataSourceList, i, i + 1);
                    }
                } else if (from > to) {
                    for (int i = from; i > to; i--) {
                        Collections.swap(dataSourceList, i, i - 1);
                    }
                }

                dataSourceList.set(to, temp);

                mSimpleAdapter.notifyDataSetChanged();


            }
        });
    }

}
