package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-08 23:32
 * @Description 用户订单类
 */
public class PersonalMyOrderActivity extends BaseActivity{

    private TextView topBarBack1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_order;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack1 = (TextView) findViewById(R.id.top_bar_back);
    }

    @Override
    public void initEvent() {
//        topBarBack.setOnClickListener(this);
        topBarBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.top_bar_back:
//                finish();
//                break;
//            default:
//                break;
//        }
//    }
}