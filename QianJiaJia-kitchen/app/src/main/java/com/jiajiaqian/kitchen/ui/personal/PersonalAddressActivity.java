package com.jiajiaqian.kitchen.ui.personal;

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

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 用户收货地址类
 * @Date 2017-03-15 14:12
 * @email qianjiajia_2013@126.com
 */
public class PersonalAddressActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private Button mAddAddressListBtn;

    private TextView topBarBack;
    private TextView editAddress;
    private TextView topBarTitle;

    private List<AddressBean> mAddressBean;
    private PersonalAddressAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_address;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mAddressBean = new ArrayList<>();
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mAddressBean.add( new AddressBean("qianjiajia","18482173219","四川省成都市一环路南四段16号",1));
        mRecyclerView.setAdapter(mAdapter = new PersonalAddressAdapter(PersonalAddressActivity.this, R.layout.activity_personal_info_address_item, mAddressBean));
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.address_recycler);
        mAddAddressListBtn = (Button) findViewById(R.id.bt_add_address_list);
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        editAddress = (TextView) findViewById(R.id.tv_edit_address);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("我的收货地址");

        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
    }

    public void editClick(View view){
        Intent intent = new Intent(PersonalAddressActivity.this,PersonalAddressEditActivity.class);
        startActivity(intent);
    }

    @Override
    public void initEvent() {
        mAddAddressListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalAddressActivity.this, PersonalAddressAddActivity.class);
                startActivity(intent);
            }
        });

//        mAddressListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(PersonalAddressActivity.this,PersonalAddressEditActivity.class);
//                startActivity(intent);
//            }
//        });

        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}