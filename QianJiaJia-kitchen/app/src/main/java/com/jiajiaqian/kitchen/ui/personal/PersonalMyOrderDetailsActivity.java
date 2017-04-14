package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.MyOrderDetailsBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.shop.adapter.ShopAccountActivityAdapter;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private RecyclerView mRecyclerView;
    private TextView nameOrderDetails;
    private TextView addressOrderDetails;
    private TextView phoneOrderDetails;
    private TextView orderNumberDetails;
    private TextView orderCreateDetails;
    private TextView payOrderDetails;
    private TextView postageOrderDetails;
    private TextView totalOrderDetails;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_order_details;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Intent it = getIntent();
        KitchenHttpManager.getInstance().orderDetail(it.getStringExtra("orderId"), new OkJsonRequest.OKResponseCallback() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-order-details--", jsonObject + "");
                if (jsonObject != null) {
                    MyOrderDetailsBean myOrderDetailsBean = GsonUtils.jsonToBean(jsonObject.toString(), MyOrderDetailsBean.class);
                    if (myOrderDetailsBean.getDetails() != null) {
                        getDetailsData(myOrderDetailsBean.getDetails());
                    }
                    if(myOrderDetailsBean.getProduct() != null){
                        getProductList(myOrderDetailsBean.getProduct());
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-order--details--", volleyError.getMessage() + "");
            }
        });

    }

    private void getProductList(List<MyOrderDetailsBean.ProductBean> product) {
        ShopAccountActivityAdapter adapter = new ShopAccountActivityAdapter(PersonalMyOrderDetailsActivity.this, R.layout.activity_personal_info_order_details_item, product);
        mRecyclerView.setAdapter(adapter);
    }

    private void getDetailsData(MyOrderDetailsBean.DetailsBean details) {
        addressOrderDetails.setText(details.getOrderConsigneeAddress());
        nameOrderDetails.setText(details.getOrderConsigneeName());
        phoneOrderDetails.setText(details.getOrderConsigneePhone());
        orderNumberDetails.setText(details.getOrderRef());
        orderCreateDetails.setText(getStrTime(details.getOrderCreateDate()+""));
        payOrderDetails.setText(details.getOrderActualPayment()+"");
        postageOrderDetails.setText(details.getOrderCarriage()+"");
        totalOrderDetails.setText(details.getOrderTotalPayment()+"");
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topbarTitle = (TextView) findViewById(R.id.top_bar_title);
        topbarTitle.setText("订单详情");
        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_order_details_personal_info);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
        nameOrderDetails = (TextView) findViewById(R.id.name_order_details);
        addressOrderDetails = (TextView) findViewById(R.id.address_order_details);
        phoneOrderDetails = (TextView) findViewById(R.id.phone_order_details);
        orderNumberDetails = (TextView) findViewById(R.id.tv_order_number_order_details);
        orderCreateDetails = (TextView) findViewById(R.id.tv_create_date_order_details);
        payOrderDetails = (TextView) findViewById(R.id.tv_pay_order_details);
        postageOrderDetails = (TextView) findViewById(R.id.tv_postage_order_details);
        totalOrderDetails = (TextView) findViewById(R.id.tv_total_order_details);
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


    /**
     * 将时间戳转换成时间格式yyyy-MM-dd hh:mm:ss
     */
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}