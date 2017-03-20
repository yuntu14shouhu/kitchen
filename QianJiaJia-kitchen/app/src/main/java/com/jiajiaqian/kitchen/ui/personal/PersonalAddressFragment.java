package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 9:04
 * @Description 用户收货地址类
 */
public class PersonalAddressFragment extends BaseFragment{

    private RecyclerView mAddressListView;
    private Button mAddAddressListBtn;

    private List<AddressBean> mAddressBean;
    private PersonalAddressAdapter mPersonalAddressAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_info_address;
    }

    @Override
    protected void initView() {
        mAddressListView = (RecyclerView) mRootView.findViewById(R.id.address_listView);
        mAddAddressListBtn = (Button) mRootView.findViewById(R.id.bt_add_address_list);

        mAddressListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAddressListView.setAdapter(mPersonalAddressAdapter = new PersonalAddressAdapter());
    }

    @Override
    protected void initData() {
        mAddressBean = new ArrayList<>();
        AddressBean addressBean = new AddressBean();
/*        addressBean.setName("qianjiajia");
        addressBean.setPhone("18482173219");
        addressBean.setAddress("四川省成都市一环路南四段16号");*/
        mAddressBean.add(addressBean);
        mAddressBean.add(addressBean);
    }

    @Override
    protected  void initListener(){
        super.initListener();
        mAddAddressListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),PersonalAddressAddFragment.class);
            }
        });
    }
}