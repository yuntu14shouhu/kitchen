package com.jiajiaqian.kitchen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/6.
 */

public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        },2000);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }
}
