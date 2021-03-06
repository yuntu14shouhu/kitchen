package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.common.entity.AddressListBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.common.utils.UserInfoUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

import org.json.JSONObject;

import java.util.ArrayList;

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

    private AddressBean mAddressBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_address;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        if (UserInfoUtils.getUserId(this) != null) {
            KitchenHttpManager.getInstance().getAddressLists(UserInfoUtils.getUserId(this)+"", new OkJsonRequest.OKResponseCallback() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("error-address-pre-", volleyError.getMessage() + "");
                }

                @Override
                public void onResponse(JSONObject jsonObject) {
                    Log.e("error-address-pre-", jsonObject + "");
                    if (jsonObject != null) {
                        AddressListBean addressListBean = GsonUtils.jsonToBean(jsonObject.toString(), AddressListBean.class);
                        if (addressListBean.getData() != null) {
                            getAddressData(addressListBean.getData());
                        }
                    }
                }
            });
        }
    }

    private void getAddressData(ArrayList<AddressBean> data) {
        PersonalAddressAdapter adapter = new PersonalAddressAdapter(PersonalAddressActivity.this, R.layout.activity_personal_info_address_item, data);
        mRecyclerView.setAdapter(adapter);
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

    public void editClick(View view) {
        Intent intent = new Intent(PersonalAddressActivity.this, PersonalAddressEditActivity.class);
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