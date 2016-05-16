package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.SecretTextView;

/**
 * 文字随机显示消失
 * Created by C.jiuxu on 2015/6/17.
 */
public class SecretTextViewActivity extends AppCompatActivity {

    private SecretTextView secretTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_text_view);
        secretTextView = (SecretTextView) findViewById(R.id.activity_secret_text_view_secrettextview);
        secretTextView.setText("经过一年多的发展，基于Mandriva的社区发行版Mageia非常自豪地在官网宣布了Mageia 5的到来Mageia 是基于 GNU/Linux 的自由软件操作系统。这是一项社区项目，由经推选的志愿者组成的非营利性机构所支持。 以下为官方博客文章摘译 我们选择花费大量的时间来解决重大问题，以此来获得一个高品质的版本，而不是急于求成。Mageia 5或许是迄今为止最好的版本，主要是安装更加地便捷顺利、增加了诸多新功能和修复了一系列的bug");
        secretTextView.setmDuration(3000);
        secretTextView.setIsVisible(true);

        secretTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secretTextView.toggle();
            }
        });
    }
}
