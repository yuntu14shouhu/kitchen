package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.common.entity.UserBean;
import com.jiajiaqian.kitchen.common.entity.UserDataBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

import org.json.JSONObject;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 0:09
 * @Description 用户资料类
 */
public class PersonalMyDataActivity extends BaseActivity {

    //    private ImageButton mBackIb;
//    private TextView mEditMyDatatv;
    private TextView mNameMyDatatv;
    private TextView mNickNameMyDatatv;
    private TextView mSexMyDatatv;
    private TextView mBirthDateMyDatatv;
    private TextView mEmailMyDatatv;
    private TextView mPhoneMyDatatv;
    private TextView mQQMyDatatv;

    private TextView topBarBack;
    private TextView topBarTitle;
    private Button mEditMyDataBt;

    private ACache mACache;
    private UserBean mUserBean = new UserBean();

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_mydata;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        KitchenHttpManager.getInstance().userData("", new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-userdata-pre-", volleyError.getMessage() + "");
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-userdata-pre-", jsonObject + "");
                if (jsonObject != null) {
                    UserDataBean userDataBean = GsonUtils.jsonToBean(jsonObject.toString(), UserDataBean.class);
                    UserBean userBean = userDataBean.getData();
                    if (userBean != null) {
                        System.out.println(userBean.getUserName());
                        mNameMyDatatv.setText(userBean.getUserName());
                        mNickNameMyDatatv.setText(userBean.getNickName());
                        mSexMyDatatv.setText(userBean.getSex());
                        mBirthDateMyDatatv.setText(userBean.getAge()+"");
                        mEmailMyDatatv.setText(userBean.getEmail());
                        mPhoneMyDatatv.setText(userBean.getPhone());
                        mQQMyDatatv.setText(userBean.getQqnumber());
                    }
                }
            }
        });
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        mEditMyDataBt = (Button) findViewById(R.id.top_bar_right);
        mNameMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_name);
        mNickNameMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_nickname);
        mSexMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_sex);
        mBirthDateMyDatatv = (TextView)findViewById(R.id.tv_info_mydata_birthdate);
        mEmailMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_email);
        mPhoneMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_phone);
        mQQMyDatatv = (TextView) findViewById(R.id.tv_info_mydata_qq);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("我的资料");
        mEditMyDataBt.setText("编辑");
        mACache = ACache.get(this);
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mEditMyDataBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalMyDataActivity.this,PersonalMyDataEditActivity.class);
                intent.putExtra("name",mACache.getAsString("name"));
                intent.putExtra("nickname",mACache.getAsString("nickname"));
                intent.putExtra("sex",mACache.getAsString("sex"));
                intent.putExtra("birthdate",mACache.getAsString("birthdate"));
                intent.putExtra("email",mACache.getAsString("email"));
                intent.putExtra("phone",mACache.getAsString("phone"));
                intent.putExtra("qq",mACache.getAsString("qq"));
                startActivity(intent);
            }
        });
    }
}