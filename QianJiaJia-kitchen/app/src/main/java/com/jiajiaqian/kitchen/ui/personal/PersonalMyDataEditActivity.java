package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-08 23:08
 * @Description 用户个人资料编辑
 */
public class PersonalMyDataEditActivity extends BaseActivity{

    private TextView topBarBack;
    private TextView topTitle;
    private Button topBtn;


    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_mydata_edit;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topTitle = (TextView) findViewById(R.id.top_bar_title);
        topBtn = (Button) findViewById(R.id.top_bar_right);
        topTitle.setText("我的资料");
        topBtn.setText("保存");
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}