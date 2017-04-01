package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderDetailsBean;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.shop.adapter.ShopAccountActivityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单详情查看
 * @Date 2017-03-27 16:45
 * @email qianjiajia_2013@126.com
 */
public class PersonalMyOrderDetailsActivity extends BaseActivity {

    private TextView topBarBack;
    private TextView topbarTitle;
    private List<OrderDetailsBean> mOrderDetailsBeanList;
    private RecyclerView mRecyclerView;
    private ShopAccountActivityAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_order_details;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mOrderDetailsBeanList = new ArrayList<>();
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶三叶草三叶草三叶草三叶草三叶草三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topbarTitle = (TextView) findViewById(R.id.top_bar_title);
        topbarTitle.setText("订单详情");
        mRecyclerView = (RecyclerView)findViewById(R.id.rcv_order_details_personal_info);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter = new ShopAccountActivityAdapter(PersonalMyOrderDetailsActivity.this, R.layout.activity_personal_info_order_details_item, mOrderDetailsBeanList));
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