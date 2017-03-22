package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description Kitchen介绍
 * @Date 2017-03-16 16:16
 * @email qianjiajia_2013@126.com
 */
public class PersonalAboutKitchenActivity extends BaseActivity {

    private TextView topBarBack;
    private TextView topBarTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_setting_about_kitchen;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("关于Kitchen");
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}