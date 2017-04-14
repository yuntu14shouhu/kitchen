package com.jiajiaqian.kitchen.ui.personal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

import org.json.JSONObject;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 用户编辑收货地址类
 * @Date 2017-03-15 14:01
 * @email qianjiajia_2013@126.com
 */
public class PersonalAddressEditActivity extends BaseActivity{

    private TextView mAddressTopBarBack;
    private TextView mAddressTopBarTitle;
    private EditText mInfoAddressNameEt;
    private EditText mInfoAddressPhoneEt;
    private Spinner mInfoAddressCitySp;
    private EditText mInfoAddressAddressEt;
    private EditText mInfoAddressNumberEt;
    private Button mSaveAddress;
    private Button mDeletaAddress;
    private String addressId;

    private RadioGroup mRadioGroup;

    private ACache mACache;

    private String mAddrSpStr = "成都市";

    private AddressBean mAddressBean,updateAddressBean;

    private CustomToast toast;

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_address_edit;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Intent it = getIntent();
        KitchenHttpManager.getInstance().getAddressDetails(it.getStringExtra("addressId"), new OkJsonRequest.OKResponseCallback() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-address-details", jsonObject + "");
                if (jsonObject != null) {
                    AddressBean addressBean = GsonUtils.jsonToBean(jsonObject.toString(), AddressBean.class);
                    if (addressBean.getId()!= null) {
                        mInfoAddressNameEt.setText(addressBean.getConsigneeName());
                        mInfoAddressPhoneEt.setText(addressBean.getConsigneePhone());
                        //spring----省份选择
                        mInfoAddressAddressEt.setText(addressBean.getConsigneeAddress());
                        mInfoAddressNumberEt.setText(addressBean.getHouseNumber());
                        //radiogroup----地址类型选择
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-address-details", volleyError.getMessage() + "");
            }
        });

    }


    @Override
    public void initView() {
        mAddressTopBarBack = (TextView) findViewById(R.id.top_bar_back);
        mAddressTopBarTitle = (TextView) findViewById(R.id.top_bar_title);
        mInfoAddressNameEt = (EditText) findViewById(R.id.et_personal_info_address_name);
        mInfoAddressPhoneEt = (EditText) findViewById(R.id.et_personal_info_address_phone);
        mInfoAddressCitySp = (Spinner) findViewById(R.id.sp_personal_info_address);
        mInfoAddressAddressEt = (EditText) findViewById(R.id.et_personal_info_address_address);
        mInfoAddressNumberEt = (EditText) findViewById(R.id.et_personal_info_address_num);
        mSaveAddress = (Button) findViewById(R.id.btn_save_address);
        mDeletaAddress = (Button) findViewById(R.id.btn_delete_address);

        mRadioGroup = (RadioGroup) findViewById(R.id.radio_address);
        mAddressTopBarTitle.setText("编辑收货地址");
        mACache = ACache.get(this);

        initSpinner();
        initSpinnerText();
    }

    private void initSpinner(){
        ArrayAdapter<String> adapterAddr = new ArrayAdapter<String>(this, R.layout.personal_myspinner,
                getResources().getStringArray(R.array.province));
        adapterAddr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mInfoAddressCitySp.setAdapter(adapterAddr);
    }

    private void initSpinnerText() {
        if(mACache.getAsString("mAddrSpStr") != null)
        {
            mAddrSpStr = mACache.getAsString("mAddrSpStr");
        }
    }

    @Override
    public void initEvent() {
        mAddressTopBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mSaveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(updateAddress() != null){
                    postAddressData(updateAddress());

                    if (getIntent().getStringExtra("address_data_update") != null &&
                            getIntent().getStringExtra("address_data_update").equals("address_data")) {
                        Intent intent = new Intent();
                        intent.putExtra("newAddressData", updateAddressBean);
                        setResult(2, intent);
                        finish();
                    }
                }
                toastMessage("收货地址修改成功");
            }
        });

        mDeletaAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setSpinnerListeners();
    }

    private void postAddressData(JSONObject jsonObject) {
    }

    private JSONObject updateAddress() {
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }


    private void setSpinnerListeners() {
        mInfoAddressCitySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mAddrSpStr = mInfoAddressCitySp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(PersonalAddressEditActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }

    protected void setupViews(Bundle bundle) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
}