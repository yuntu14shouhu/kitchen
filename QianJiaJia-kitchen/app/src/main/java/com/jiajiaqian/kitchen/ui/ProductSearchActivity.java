package com.jiajiaqian.kitchen.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * Created by jasonxu on 2017/2/26.
 */

public class ProductSearchActivity extends BaseActivity{

    private ImageButton mBackBtn;
    private TextView mSearchBtn;
    private Button mClearBtn;
    private EditText mWord;
    private RecyclerView mHotListView,mHistoryListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_product_search;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        mBackBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mSearchBtn = (TextView) this.findViewById(R.id.tv_search);
        mClearBtn = (Button) this.findViewById(R.id.btn_clear_history);
        mWord = (EditText) this.findViewById(R.id.et_word);
        mHistoryListView = (RecyclerView) this.findViewById(R.id.rcy_history_search);
        mHotListView = (RecyclerView) this.findViewById(R.id.rcy_hot_search);

        mHotListView.setHasFixedSize(true);
        mHotListView.setItemAnimator(new DefaultItemAnimator());
        mHotListView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mHistoryListView.setHasFixedSize(true);
        mHistoryListView.setItemAnimator(new DefaultItemAnimator());
        mHistoryListView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initEvent() {

    }
}
