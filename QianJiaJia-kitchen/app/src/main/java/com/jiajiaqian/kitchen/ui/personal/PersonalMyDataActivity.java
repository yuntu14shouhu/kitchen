package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.common.entity.microbean.UserBean;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 0:09
 * @Description 用户资料类
 */
public class PersonalMyDataActivity extends BaseActivity implements View.OnClickListener{

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
    public int getLayoutId() {
        return R.layout.activity_personal_info_mydata;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        mBackIb = (ImageButton) findViewById(R.id.ib_personal_info_back);
        mEditMyDatatv = (TextView)findViewById(R.id.tv_personal_info_mydata);
        mNameMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_name);
        mNickNameMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_nickname);
        mSexMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_sex);
        mBirthDateMyDatatv = (TextView)findViewById(R.id.tv_info_mydata_birthdate);
        mEmailMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_email);
        mPhoneMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_phone);
        mQQMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_qq);
        mACache = ACache.get(this);
    }

    @Override
    public void initEvent() {
        mBackIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mEmailMyDatatv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.ib_personal_info_back:

            case R.id.tv_personal_info_mydata:
                Intent intent = new Intent();
                intent.setClass(this,PersonalMyDataEditActivity.class);
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