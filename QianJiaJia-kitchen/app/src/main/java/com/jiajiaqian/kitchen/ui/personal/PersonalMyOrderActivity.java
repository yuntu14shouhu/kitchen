package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderBean;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-08 23:32
 * @Description 用户订单类
 */
public class PersonalMyOrderActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    private TextView topBarBack;
    private TextView topBarTitle;
    private RecyclerView orderRecyclerView;

    private PersonalMyOrderRecyclerAdapter adapter;
    private SwipeRefreshLayout mRefreshLayout;

    private List<OrderBean> mOrderBeanList;



    public static PersonalMyOrderActivity newInstance() {
        PersonalMyOrderActivity f = new PersonalMyOrderActivity();
        return f;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_order;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        mOrderBeanList = new ArrayList<>();
        mOrderBeanList.add(new OrderBean("2017-02-22", R.drawable.ic_logo,22.0));
        mOrderBeanList.add(new OrderBean("2017-03-22", R.drawable.ic_logo,22.0));
        mOrderBeanList.add(new OrderBean("2017-04-22", R.drawable.ic_logo,22.0));
        mOrderBeanList.add(new OrderBean("2017-05-22", R.drawable.ic_logo,22.0));
        mOrderBeanList.add(new OrderBean("2017-06-22", R.drawable.ic_logo,22.0));
        mOrderBeanList.add(new OrderBean("2017-07-22", R.drawable.ic_logo,22.0));

    }

    private String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("我的订单");
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.lay_refresh_order);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        mRefreshLayout.setOnRefreshListener(this);
        orderRecyclerView = (RecyclerView) findViewById(R.id.order_lv);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        orderRecyclerView.setLayoutManager(linearLayoutManager);
        orderRecyclerView.setLayoutManager(new GridLayoutManager(orderRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));

        orderRecyclerView.setAdapter(adapter = new PersonalMyOrderRecyclerAdapter(PersonalMyOrderActivity.this, R.layout.activity_personal_info_order_edit, mOrderBeanList));
    }


    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        orderRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
                List<OrderBean> results = adapter.getResults();
                results.add(0, new OrderBean("", R.drawable.ic_logo));
                results.add(0, new OrderBean("", R.drawable.ic_logo));
                adapter.notifyDataSetChanged();
            }
        }, 1000);
    }
}