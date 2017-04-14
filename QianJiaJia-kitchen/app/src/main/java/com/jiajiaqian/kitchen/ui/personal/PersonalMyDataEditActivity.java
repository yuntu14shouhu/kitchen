package com.jiajiaqian.kitchen.ui.personal;

import android.content.DialogInterface;
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
import com.jiajiaqian.kitchen.common.entity.UserBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;
import com.jiajiaqian.kitchen.utils.MyCommonDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-08 23:08
 * @Description 用户个人资料编辑
 */
public class PersonalMyDataEditActivity extends BaseActivity {

    private TextView topBarBack;
    private TextView topTitle;
    private Button topBtn;
    //用户名不允许修改
    private EditText nicknameEdit;
    private EditText remarkEdit;
    private EditText sexEdit;
    private EditText ageEdit;
    private EditText emailEdit;
    private EditText phoneEdit;
    private EditText qqNumberEdit;

    private CustomToast toast;

    private UserBean mUserBean,newUserBean;
    private List<String> oldContentList;


    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_mydata_edit;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        oldContentList = new ArrayList<>();
        newUserBean = new UserBean();
        //从myData页面来
        Intent intent = getIntent();
        mUserBean = (UserBean) intent.getSerializableExtra("userData");
//        oldContentList.add(mUserBean.getNickName());
//        oldContentList.add(mUserBean.getRemark());
//        oldContentList.add(mUserBean.getSex());
//        oldContentList.add(mUserBean.getAge()+"");
        nicknameEdit.setText(mUserBean.getNickName());
        remarkEdit.setText(mUserBean.getRemark());
        sexEdit.setText(mUserBean.getSex());
        ageEdit.setText(mUserBean.getAge()+"");
        emailEdit.setText(mUserBean.getEmail());
        phoneEdit.setText(mUserBean.getPhone());
        qqNumberEdit.setText(mUserBean.getQqnumber());
    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topTitle = (TextView) findViewById(R.id.top_bar_title);
        topBtn = (Button) findViewById(R.id.top_bar_right);
        topTitle.setText("我的资料");
        topBtn.setText("保存");
        nicknameEdit = (EditText) findViewById(R.id.et_info_mydata_name_edit);
        remarkEdit = (EditText) findViewById(R.id.et_info_mydata_remark_edit);
        sexEdit = (EditText) findViewById(R.id.et_info_mydata_sex_edit);
        ageEdit = (EditText) findViewById(R.id.et_info_mydata_birthdate_edit);
        emailEdit = (EditText) findViewById(R.id.et_info_mydata_email_edit);
        phoneEdit = (EditText) findViewById(R.id.et_info_mydata_phone_edit);
        qqNumberEdit = (EditText) findViewById(R.id.et_info_mydata_qq_edit);
    }

    private boolean hasChanged(){
        boolean hasChanged = false;
        if (!nicknameEdit.getText().toString().equals(mUserBean.getNickName())
                || !remarkEdit.getText().toString().equals(mUserBean.getRemark())
                || !sexEdit.getText().toString().equals(mUserBean.getSex())
                || !ageEdit.getText().toString().equals(mUserBean.getAge())
                || !emailEdit.getText().toString().equals(mUserBean.getEmail())
                || !phoneEdit.getText().toString().equals(mUserBean.getPhone())
                || !qqNumberEdit.getText().toString().equals(mUserBean.getQqnumber())){
            hasChanged =true;
        }
        return hasChanged;
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasChanged()){
                    new MyCommonDialog(PersonalMyDataEditActivity.this,"您已经修改个人资料，是否需要保存？" ,"Kitchen发货","保存","取消")
                            .setOnDiaLogListener(new MyCommonDialog.OnDialogListener() {
                                @Override
                                public void dialogListener(String btnType, View customView, DialogInterface dialogInterface, int which) {
                                    switch (btnType){
                                        case "positive":
                                            toastMessage("正在保存个人资料...");
                                            if(updateUser() != null){
                                                postUserData(updateUser());
                                                //从myData页面来
                                                if (getIntent().getStringExtra("user_data_update") != null &&
                                                        getIntent().getStringExtra("user_data_update").equals("user_data")) {
                                                    Intent intent = new Intent();
                                                    intent.putExtra("newUserData", newUserBean);
                                                    setResult(2, intent);
                                                    finish();
                                                }
                                                dialogInterface.dismiss();
                                            toastMessage("我的资料修改成功");
                                            }
                                            break;
                                        case "negative":
                                            dialogInterface.dismiss();
                                            finish();
                                            break;
                                    }
                                }
                            }).showDialog();
                }else {
                    finish();
                }
            }
        });

        topBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(updateUser() != null){
                   postUserData(updateUser());
                    //从myData页面来
                    if (getIntent().getStringExtra("user_data_update") != null &&
                            getIntent().getStringExtra("user_data_update").equals("user_data")) {
                        Intent intent = new Intent();
                        intent.putExtra("newUserData", newUserBean);
                        setResult(2, intent);
                        finish();
                    }
                }
                toastMessage("我的资料修改成功");
            }
        });
    }

    private JSONObject updateUser() {
        JSONObject jsonObject = new JSONObject();

        try {
            if (!TextUtils.isEmpty(nicknameEdit.getText() + "")) {
                jsonObject.put("nickName", nicknameEdit.getText());
                newUserBean.setNickName(nicknameEdit.getText().toString());
            }else {
                Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(remarkEdit.getText() + "")) {
                jsonObject.put("remark", remarkEdit.getText());
                newUserBean.setRemark(remarkEdit.getText().toString());
            }else {
                Toast.makeText(this, "请输入备注", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(sexEdit.getText() + "")) {
                jsonObject.put("sex", sexEdit.getText());
                newUserBean.setSex(sexEdit.getText().toString());
            }else {
                Toast.makeText(this, "请输入性别", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(ageEdit.getText() + "")) {
                jsonObject.put("age", ageEdit.getText());
                newUserBean.setAge(Integer.valueOf(ageEdit.getText().toString()));
            }else {
                Toast.makeText(this, "请输入年龄", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(emailEdit.getText() + "")) {
                jsonObject.put("email", emailEdit.getText());
                newUserBean.setEmail(emailEdit.getText().toString());
            }else {
                Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(phoneEdit.getText() + "")) {
                jsonObject.put("phone", phoneEdit.getText());
                newUserBean.setPhone(phoneEdit.getText().toString());
            }else {
                Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(qqNumberEdit.getText() + "")) {
                jsonObject.put("qqnumber", qqNumberEdit.getText());
                newUserBean.setQqnumber(qqNumberEdit.getText().toString());
            }else {
                Toast.makeText(this, "请输入QQ号码", Toast.LENGTH_SHORT).show();
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObject;

    }
    private void postUserData(JSONObject jsonObject) {
        KitchenHttpManager.getInstance().userDataUpdate("", jsonObject, new OkJsonRequest.OKResponseCallback(){

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

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(PersonalMyDataEditActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }
}