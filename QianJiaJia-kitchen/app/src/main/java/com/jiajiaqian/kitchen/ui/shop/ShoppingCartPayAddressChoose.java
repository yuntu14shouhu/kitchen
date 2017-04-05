package com.jiajiaqian.kitchen.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.personal.PersonalAddressAddActivity;
import com.jiajiaqian.kitchen.ui.personal.PersonalAddressEditActivity;
import com.jiajiaqian.kitchen.ui.shop.adapter.ShoppingCartPayAddressChooseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 下单时地址选择
 * @Date 2017-04-01 11:08
 * @email qianjiajia_2013@126.com
 */
public class ShoppingCartPayAddressChoose extends BaseActivity {

    private TextView topBarBack;
    private TextView topBarTitle;
    private TextView tvEditAddress;
    private Button btAddAddress;

    private RecyclerView mRecyclerView;
    private List<AddressBean> mAddressBean;
    private ShoppingCartPayAddressChooseAdapter mAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_shoppingcart_acctounts_address_choose;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mAddressBean = new ArrayList<>();
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mAddressBean.add(new AddressBean("qianjiajia", "18482173219", "四川省成都市一环路南四段16号", 1));
        mRecyclerView.setAdapter(mAdapter = new ShoppingCartPayAddressChooseAdapter(ShoppingCartPayAddressChoose.this, R.layout.activity_shoppingcart_acctounts_address_choose_item, mAddressBean));
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("选择收货地址");
        tvEditAddress = (TextView) findViewById(R.id.tv_choose_edit_address);
        btAddAddress = (Button) findViewById(R.id.bt_choose_add_address_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_choose);

        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
    }

    public void chooseEditClick(View view) {
        Intent intent = new Intent(ShoppingCartPayAddressChoose.this, PersonalAddressEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartPayAddressChoose.this, PersonalAddressAddActivity.class);
                startActivity(intent);
            }
        });
    }
}