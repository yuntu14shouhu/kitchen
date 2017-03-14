package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_setting;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
    }

    @Override
    public void initView() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initEvent() {

    }
}