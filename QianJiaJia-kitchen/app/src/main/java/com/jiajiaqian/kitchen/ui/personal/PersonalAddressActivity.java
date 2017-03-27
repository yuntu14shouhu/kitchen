package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.personal.adapter.CommonAdaper;
import com.jiajiaqian.kitchen.ui.personal.adapter.ViewHolder;

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

    private ListView mAddressListView;
    private Button mAddAddressListBtn;

    private TextView topBarBack;
    private TextView editAddress;
    private TextView topBarTitle;

    private List<AddressBean> mAddressBean;
    private CommonAdaper<AddressBean> mCommonAdaper;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_address;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mAddressBean = new ArrayList<>();
        AddressBean addressBean = new AddressBean();
        addressBean.setConsigneeName("qianjiajia");
        addressBean.setConsigneePhone("18482173219");
        addressBean.setConsigneeAddress("四川省成都市一环路南四段16号");
        mAddressBean.add(addressBean);
        mAddressBean.add(addressBean);
    }

    @Override
    public void initView() {
        mAddressListView = (ListView) findViewById(R.id.address_listView);
        mAddAddressListBtn = (Button) findViewById(R.id.bt_add_address_list);
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        editAddress = (TextView) findViewById(R.id.tv_edit_address);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("我的收货地址");
        initAdapter();
        mAddressListView.setAdapter(mCommonAdaper);

    }

    private void initAdapter() {

        mCommonAdaper = new CommonAdaper<AddressBean>(this, mAddressBean, R.layout.activity_personal_info_address_item) {
            @Override
            public void convert(ViewHolder holder, AddressBean item) {
                holder.setText(R.id.tv_personal_info_add_address_name, item.getConsigneeName());
                holder.setText(R.id.tv_personal_info_add_address_phone, item.getConsigneePhone());
                holder.setText(R.id.tv_personal_info_add_address_address, item.getConsigneeAddress());

            }
        };
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