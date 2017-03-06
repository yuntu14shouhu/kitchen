package com.jiajiaqian.kitchen.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.ActivityUtil;

import org.json.JSONException;

/**
 * Created by jiajiaQian on 2017/2/18.
 * 登录
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mRegisterBtn;
    private Button mForgetpwBtn;
    private Button mLoginBtn;

    private EditText mUsernameET;
    private EditText mPasswordET;

    private String mUsernameStr;
    private String mPasswordStr;

    private String userNameGet;
    private String userPasswordGet;

    private ACache mCache;

    private int index = 0;

    public final static int SAVE_TO_LOCALCACHE = 1;// 保存信息到本地

    @Override
    public int getLayoutId() {
        return R.layout.activity_kitchen_login;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        mRegisterBtn = (Button) findViewById(R.id.btn_main_login_register);
        mForgetpwBtn = (Button) findViewById(R.id.btn_main_login_forgetpw);
        mLoginBtn = (Button) findViewById(R.id.btn_main_login);
        mUsernameET = (EditText) findViewById(R.id.et_main_login_username);
        mPasswordET = (EditText) findViewById(R.id.et_main_login_password);
    }

    @Override
    public void initEvent() {
        mRegisterBtn.setOnClickListener(this);
        mForgetpwBtn.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_main_login_register:
                alertDialog();
            case R.id.btn_main_login_forgetpw:
                startActivity(new Intent(LoginActivity.this,LoginFindpwWayActivity.class));
            case R.id.btn_main_login:
                // 登陆,获取EditText的内容,在数据库中查找是否该用户已经注册,以及密码是否正确
                login();
                break;
            default:
                break;
        }
    }

    private void login() {
        mUsernameStr = mUsernameET.getText().toString();
        mPasswordStr = mPasswordET.getText().toString();
        if(mUsernameStr.equals(" ") || mPasswordStr.equals("")){
            ActivityUtil.showToastBytTime(this, "用户名/密码不能为空", 2000);
        }else {
            /**
             * 从数据库中查询到相对应的用户名和密码
             */
        }
    }

    /**
     * 弹出单选对话框,以选择是手机注册还是邮箱注册
     */
    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("请选择注册方式")
                .setSingleChoiceItems(R.array.leftmenu_register_way,0,new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        index = which;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                String str = getResources().getStringArray(R.array.leftmenu_register_way)[index];
                if (str.equals("手机注册")) {
                    startActivity(new Intent(LoginActivity.this, LoginPhoneRegisterActivity.class));
                    finish();
                }
                if (str.equals("邮箱注册")) {
                    startActivity(new Intent(LoginActivity.this, LoginEmailRegisterActivity.class));
                    finish();
                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

//    public Handler mHandler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case SAVE_TO_LOCALCACHE:
//                    try {
//                        saveToLocalCache();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                default:
//                    break;
//            }
//            super.handleMessage(msg);
//        }
//    };

    /**
     * 保存数据到本地
     *
     * @throws JSONException
     */
//    private void saveToLocalCache() throws JSONException {
//        mCache.put("nickname", getByKey("userNickname"));
//        mCache.put("realname", getByKey("realName"));
//        mCache.put("loginphone", getByKey("mobilePhoneNumber"));
//        mCache.put("loginemail", getByKey("email"));
//        mCache.put("saveflow", User.getObjectByKey("saveflow").toString());
//
//        // 将头像存储到本地
//        if (User.getObjectByKey("headimg") == null) {
//            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon_default_main);
//            mCache.put("headimg", bm);
//        }
//
//        else {
//            int netType = getNetworkType();
//            if (mCache.getAsString("saveflow").equals("1")) {
//                if (netType == ConnectivityManager.TYPE_WIFI) {
//                    downloadHeadimg(((JSONObject) User.getObjectByKey("headimg")).getString("url"));
//                } else {
//                    ActivityUtil.showToastBytTime(this, "获取头像失败,在wifi环境下会自动下载", 2000);
//                    // toast("获取头像失败,在wifi环境下会自动下载");
//                    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon_default_main);
//                    mCache.put("headimg", bm);
//                }
//            } else {
//                // toast(mCache.getAsString("saveflow"));
//                downloadHeadimg(((JSONObject) User.getObjectByKey("headimg")).getString("url"));
//            }
//
//        }
//
//        saveDetailInfoToLocal(User.getObjectByKey("objectId").toString());
//        saveSchoolInfoToLocal(User.getObjectByKey("objectId").toString());
//        saveResumeInfoToLocal(User.getObjectByKey("objectId").toString());
//        saveCollectionToLocal();
//    }
//
//    /**
//     * 根据字段返回值
//     *
//     * @param string
//     * @return
//     */
//    private String getByKey(String key) {
//        String result = "";
//        if (User.getObjectByKey(key) != null) {
//            result = User.getObjectByKey(key).toString();
//        }
//        return result;
//    }
}
