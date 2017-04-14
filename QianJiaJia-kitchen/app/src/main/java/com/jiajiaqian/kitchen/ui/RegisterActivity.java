package com.jiajiaqian.kitchen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

import org.json.JSONObject;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-02-22 17:22
 * @Description 注册
 */
public class RegisterActivity extends BaseActivity {


    private TextView topBackBar;
    private TextView mTitle;
    private Button mRegisterBtn;

    private EditText usernameEt;
    private EditText mPasswordET;
    private EditText mPasswordAgainET;

    private CustomToast toast;

    private String mPhNumStr;
    private String mIdentifyCodeStr;
    private String mPasswordStr;
    private String mPasswordAgainStr;

    @Override
    public int getLayoutId() {
        return R.layout.activity_kitchen_register;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBackBar = (TextView) findViewById(R.id.top_bar_back);
        mTitle = (TextView) findViewById(R.id.top_bar_title);
        mTitle.setText("新用户注册");
        mRegisterBtn = (Button) findViewById(R.id.btn_login_phonelogin_register);
        usernameEt = (EditText) findViewById(R.id.et_login_register_username);
        mPasswordET = (EditText) findViewById(R.id.et_login_register_password);
        mPasswordAgainET = (EditText) findViewById(R.id.et_login_register_password_agin);
    }

    @Override
    public void initEvent() {
        topBackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(saveUser() != null){
                    postSaveUserData(saveUser());
                    //从myData页面来
                    if (getIntent().getStringExtra("user_data_save") != null &&
                            getIntent().getStringExtra("user_data_save").equals("user_data")) {
                        Intent intent = new Intent();
                        intent.putExtra("newUserData", "saveUser");
                        setResult(1, intent);
                        finish();
                    }
                }
                toastMessage("注册成功");
            }
        });

    }

    private void postSaveUserData(JSONObject jsonObject) {

        KitchenHttpManager.getInstance().userSave("", jsonObject, new OkJsonRequest.OKResponseCallback(){

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success", jsonObject + "");
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error", volleyError.getMessage() + "");
            }
        });

    }


    /**
     * 保存用户即----注册
     * 判断验证码是否正确
     * 密码格式是否正确
     * 两次密码输入是否一致
     * 向数据库中插入数据
     */

    private JSONObject saveUser() {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(usernameEt.getText() + "")) {
                jsonObject.put("userName", usernameEt.getText());
            }else {
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(mPasswordET.getText() + "")) {
                jsonObject.put("password", mPasswordET.getText());
            }else {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void getEtText() {
        mPhNumStr =usernameEt.getText().toString();
//        mIdentifyCodeStr = mIdentifyCodeET.getText().toString();
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

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(RegisterActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }
}