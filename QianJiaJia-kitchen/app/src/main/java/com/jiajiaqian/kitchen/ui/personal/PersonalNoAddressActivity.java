package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 没有任何收货地址时
 * @Date 2017-03-15 14:16
 * @email qianjiajia_2013@126.com
 */
public class PersonalNoAddressActivity extends BaseActivity {

    private Button mAddressAddBtn;
    private TextView topBarBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_no_address;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        mAddressAddBtn = (Button)findViewById(R.id.btn_add_address);
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
    }

    @Override
    public void initEvent() {
        mAddressAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalNoAddressActivity.this,PersonalAddressAddActivity.class);
            }
        });
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}