package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderBean;
import com.jiajiaqian.kitchen.common.entity.OrderListBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

import org.json.JSONObject;

import java.util.ArrayList;
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

    private List<OrderListBean> mOrderBeanList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_order;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        KitchenHttpManager.getInstance().orderList("",new OkJsonRequest.OKResponseCallback(){

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-orderList--", jsonObject + "");
                if (jsonObject != null) {
                    OrderListBean orderListBean = GsonUtils.jsonToBean(jsonObject.toString(), OrderListBean.class);
                    getOrderListData(orderListBean.getOrder());
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-orderList--", volleyError.getMessage() + "");
            }
        });
    }

    private void getOrderListData(List<OrderBean> order) {
        PersonalMyOrderRecyclerAdapter adapter = new PersonalMyOrderRecyclerAdapter(PersonalMyOrderActivity.this, R.layout.activity_personal_info_order_edit, order);
        orderRecyclerView.setAdapter(adapter);
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("我的订单");
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.lay_refresh_order);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimaryPersonal, R.color.colorPrimaryDarkPersonal);
        mRefreshLayout.setOnRefreshListener(this);
        orderRecyclerView = (RecyclerView) findViewById(R.id.order_lv);

        orderRecyclerView.setLayoutManager(new GridLayoutManager(orderRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
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
        KitchenHttpManager.getInstance().orderList("",new OkJsonRequest.OKResponseCallback(){

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-orderList--", jsonObject + "");
                if (jsonObject != null) {
                    OrderListBean orderListBean = GsonUtils.jsonToBean(jsonObject.toString(), OrderListBean.class);
//                    mOrderBeanList= orderListBean.getOrder();
                    getOrderListData(orderListBean.getOrder());
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-orderList--", volleyError.getMessage() + "");
                if (mRefreshLayout.isRefreshing()) {
                    mRefreshLayout.setRefreshing(false);
                }
            }
        });
    }
}