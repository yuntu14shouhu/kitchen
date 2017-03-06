package com.jiajiaqian.kitchen.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-02-22 17:22
 * @Description 手机注册
 */
public class LoginPhoneRegisterActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LeftMenuPhoneRegisterActivity";

    private TextView mBackIB;
    private TextView mTitle;
    private Button mGetCodeBtn;
    private Button mRegisterBtn;

    private EditText mPhNumET;
    private EditText mIdentifyCodeET;
    private EditText mPasswordET;
    private EditText mPasswordAgainET;

    private String mPhNumStr;
    private String mIdentifyCodeStr;
    private String mPasswordStr;
    private String mPasswordAgainStr;

    @Override
    public int getLayoutId() {
        return R.layout.activity_kitchen_phone_register;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mTitle.setText("手机注册");
    }

    @Override
    public void initView() {
        mBackIB = (TextView) findViewById(R.id.top_bar_back);
        mTitle = (TextView) findViewById(R.id.top_bar_title);
        mGetCodeBtn = (Button) findViewById(R.id.btn_login_phoneregister_getcode);
        mRegisterBtn = (Button) findViewById(R.id.btn_login_phonelogin_register);
        mPhNumET = (EditText) findViewById(R.id.et_login_register_phone);
        mIdentifyCodeET = (EditText) findViewById(R.id.et_login_register_identifyingcode);
        mPasswordET = (EditText) findViewById(R.id.et_login_phoneregister_pw);
        mPasswordAgainET = (EditText) findViewById(R.id.et_login_phoneregister_pw_agin);
    }

    @Override
    public void initEvent() {
        mBackIB.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);
        mGetCodeBtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        /**
         * 获得编辑框内的内容
         */
        getEtText();

        switch (v.getId()){
            case R.id.btn_login_phonelogin_register:
                phoneRegister();
                break;
            case R.id.btn_login_phoneregister_getcode:
                phoneGetCode();
                break;
            case R.id.top_bar_back:
                finish();
                break;
            default:
                break;
        }
    }

    private void phoneGetCode() {
    }

    /**
     * 保存用户即----注册
     * 判断验证码是否正确
     * 密码格式是否正确
     * 两次密码输入是否一致
     * 向数据库中插入数据
     */
    private void phoneRegister() {
    }

    private void getEtText() {
        mPhNumStr = mPhNumET.getText().toString();
        mIdentifyCodeStr = mIdentifyCodeET.getText().toString();
        mPasswordStr = mPasswordET.getText().toString();
        mPasswordAgainStr = mPasswordAgainET.getText().toString();
    }

    /**
     * 密码格式是否正确
     */
    public static boolean isPassword(String Password) {

        // 8~16位,字母 数字 符号至少两种
        String strPattern = "((?=.*\\d)(?=.*\\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$";
        if (TextUtils.isEmpty(Password))
            return false;
        return Password.matches(strPattern);
    }
}