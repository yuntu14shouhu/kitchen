package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 9:06
 * @Description 联系客服类
 */
public class PersonalRelationActivity extends BaseActivity{

    private TextView topBarBack;
    private TextView topBartitle;


    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_relation;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBartitle = (TextView) findViewById(R.id.top_bar_title);
        topBartitle.setText("客服与帮助");
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