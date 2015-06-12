package com.example.administrator.myui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.myui.R;
import com.example.administrator.myui.ui.MySlipSwitch;

public class SlideButtonActivity extends ActionBarActivity {

    private MySlipSwitch slide_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_button);

        slide_button = (MySlipSwitch) findViewById(R.id.activity_slide_button_myslipswitch);
        slide_button.setImageResource(R.drawable.switch_bkg_switch, R.drawable.switch_bkg_switch, R.drawable.switch_btn_slip);

        slide_button.setOnSwitchListener(new MySlipSwitch.OnSwitchListener() {
            @Override
            public void onSwitched(boolean isSwitchOn) {

                if (isSwitchOn) {
                    Toast.makeText(SlideButtonActivity.this, "关", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SlideButtonActivity.this, "开", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
