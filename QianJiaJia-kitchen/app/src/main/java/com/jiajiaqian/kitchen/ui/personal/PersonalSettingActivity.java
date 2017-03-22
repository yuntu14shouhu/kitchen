package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 9:07
 * @Description 用户设置类
 */
public class PersonalSettingActivity extends BaseActivity{

    private TextView topBarBack;
    private TextView topBarTitle;
    private RelativeLayout rlUpdate;
    private RelativeLayout rlClean;
    private RelativeLayout rlReader;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_setting;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("设置");
        rlUpdate = (RelativeLayout) findViewById(R.id.rl_setting_update);
        rlClean = (RelativeLayout) findViewById(R.id.rl_setting_clean);
        rlReader = (RelativeLayout) findViewById(R.id.rl_setting_reader);
    }

    @Override
    public void initView() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rlUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rlClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rlReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalSettingActivity.this, PersonalAboutKitchenActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initEvent() {

    }
}