package com.jiajiaqian.kitchen.ui.home;

import android.support.v4.app.Fragment;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;

/**
 * Created by jasonxu on 2017/2/17.
 * 首页fragment
 */

public class HomeFragment extends BaseFragment {

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tab_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void initData() {

    }
}
