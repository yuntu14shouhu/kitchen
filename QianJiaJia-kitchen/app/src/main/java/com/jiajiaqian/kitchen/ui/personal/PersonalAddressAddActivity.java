package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.UserInfoUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

import org.json.JSONObject;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 新增收货地址
 * @Date 2017-03-27 15:16
 * @email qianjiajia_2013@126.com
 */
public class PersonalAddressAddActivity extends BaseActivity implements View.OnClickListener {

    private TextView topBarBack;
    private TextView topBarTitle;
    private Spinner addressCitySp;
    private Button addressSave;
    private EditText mUserName, mUserPhone, mAddress, mRom;
    private RadioGroup mAddressTypeLayout;

    private String addrSpStr = "成都市";
    private String mType;
    private ACache mACache;

    private CustomToast toast;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_address_add;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("新增收货地址");
        addressCitySp = (Spinner) findViewById(R.id.sp_personal_info_address_add);
        addressSave = (Button) findViewById(R.id.btn_save_address_add);
        mUserName = (EditText) findViewById(R.id.et_personal_info_address_name);
        mUserPhone = (EditText) findViewById(R.id.et_personal_info_address_phone_add);
        mAddress = (EditText) findViewById(R.id.et_personal_info_address_address_add);
        mRom = (EditText) findViewById(R.id.et_personal_info_address_num_add);
        mAddressTypeLayout = (RadioGroup) findViewById(R.id.rgp_type);
        mACache = ACache.get(this);

        initSpinner();
        initSpinnerText();
    }

    private void initSpinner() {
        ArrayAdapter<String> adapterAddr = new ArrayAdapter<String>(this, R.layout.personal_myspinner,
                getResources().getStringArray(R.array.province));
        adapterAddr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addressCitySp.setAdapter(adapterAddr);
    }

    private void initSpinnerText() {
        if (mACache.getAsString("addrSpStr") != null) {
            addrSpStr = mACache.getAsString("addrSpStr");
        }
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(this);
        addressSave.setOnClickListener(this);
        setSpinnerListeners();
        mAddressTypeLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                mType = radioButton.getText().toString();
            }
        });
    }

    private void setSpinnerListeners() {
        addressCitySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addrSpStr = addressCitySp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_back:
                finish();
                break;
            case R.id.btn_save_address_add:
                if (saveAddress() != null){
                    postAddress(saveAddress());
                    //从home页面来的
                    if (getIntent().getStringExtra("address_add_where") != null &&
                            getIntent().getStringExtra("address_add_where").equals("home_address")) {
                        Intent intent = new Intent();
                        intent.putExtra("newAddress", "addHas");
                        setResult(2, intent);
                        finish();
                    }
                    toastMessage("地址保存成功！");
                }
                break;
            default:
                break;
        }
    }

    private JSONObject saveAddress() {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(mUserName.getText() + "")) {
                jsonObject.put("consigneeName", mUserName.getText());
            } else {
                Toast.makeText(this, "请输入收货人姓名", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(mUserPhone.getText() + "")) {
                jsonObject.put("consigneePhone", mUserPhone.getText());
            } else {
                Toast.makeText(this, "请输入收货人电话", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(mAddress.getText() + "")) {
                jsonObject.put("consigneeAddress", addrSpStr + mAddress.getText() + mRom.getText());
            } else {
                Toast.makeText(this, "请输入收货人地址", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (!TextUtils.isEmpty(UserInfoUtils.getUserId(this) + "")) {
                jsonObject.put("userId", UserInfoUtils.getUserId(this));
            }else {
                Toast.makeText(this, "请首先登陆", Toast.LENGTH_SHORT).show();
                return null;
            }
            if (mType != null) {
                jsonObject.put("addressType", mType);
            } else {
                Toast.makeText(this, "请选择正确的地址类型", Toast.LENGTH_SHORT).show();
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;

    }

    private void postAddress(JSONObject jsonObject) {
        KitchenHttpManager.getInstance().addAddress("", jsonObject, new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error", volleyError.getMessage() + "");
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success", jsonObject + "");
            }
        });
    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(PersonalAddressAddActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }
}