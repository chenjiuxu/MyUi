package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.SecretTextView;

public class SecretTextViewActivity extends ActionBarActivity {

    private SecretTextView secretTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_text_view);
        secretTextView = (SecretTextView) findViewById(R.id.activity_secret_text_view_secrettextview);
        secretTextView.setText("cmowmcodmcovniedvjierjvbievjibhuvirth89vijribhrtvjiortjb9rtjvb90rtjnrt90jb9rt");
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
