package com.jiajiaqian.kitchen.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by t_xuz on 12/13/16.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData(savedInstanceState);
        initView();
        initEvent();
    }

    public abstract int getLayoutId();

    public abstract void initData(Bundle savedInstanceState);

    public abstract void initView();

    public abstract void initEvent();
}
