package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.common.entity.microbean.UserBean;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 0:09
 * @Description 用户资料类
 */
public class PersonalMyDataFragment extends BaseFragment implements View.OnClickListener{

    private ImageButton mBackIb;
    private TextView mEditMyDatatv;
    private TextView mNameMyDatatv;
    private TextView mNickNameMyDatatv;
    private TextView mSexMyDatatv;
    private TextView mBirthDateMyDatatv;
    private TextView mEmailMyDatatv;
    private TextView mPhoneMyDatatv;
    private TextView mQQMyDatatv;

    private ACache mACache;
    private UserBean mUserBean;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_info_mydata;
    }

    @Override
    protected void initView() {
        mBackIb = (ImageButton) mRootView.findViewById(R.id.ib_personal_info_back);
        mEditMyDatatv = (TextView) mRootView.findViewById(R.id.tv_personal_info_mydata);
        mNameMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_name);
        mNickNameMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_nickname);
        mSexMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_sex);
        mBirthDateMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_birthdate);
        mEmailMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_email);
        mPhoneMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_phone);
        mQQMyDatatv = (TextView) mRootView.findViewById(R.id.tv_info_mydata_qq);
        mACache = ACache.get(getActivity());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        super.initListener();
        mBackIb.setOnClickListener(this);
        mEmailMyDatatv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_personal_info_back:
                getActivity().finish();
            case R.id.tv_personal_info_mydata:
                Intent intent = new Intent();
                intent.setClass(getActivity(),PersonalMyDataEditFragment.class);
                intent.putExtra("name",mACache.getAsString("name"));
                intent.putExtra("nickname",mACache.getAsString("nickname"));
                intent.putExtra("sex",mACache.getAsString("sex"));
                intent.putExtra("birthdate",mACache.getAsString("birthdate"));
                intent.putExtra("email",mACache.getAsString("email"));
                intent.putExtra("phone",mACache.getAsString("phone"));
                intent.putExtra("qq",mACache.getAsString("qq"));
                startActivity(intent);
        }
    }
    
}