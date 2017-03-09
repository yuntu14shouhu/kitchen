package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 10:38
 * @Description 没有任何收货地址时
 */
public class PersonalNoAddressFragment extends BaseFragment {

    private Button mAddressAddBtn;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_info_no_address;
    }

    @Override
    protected void initView() {
        mAddressAddBtn = (Button) mRootView.findViewById(R.id.btn_add_address);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener(){
        super.initListener();
        mAddressAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),PersonalAddressAddFragment.class);
            }
        });
    }
}