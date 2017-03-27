package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 用户编辑收货地址类
 * @Date 2017-03-15 14:01
 * @email qianjiajia_2013@126.com
 */
public class PersonalAddressEditActivity extends BaseActivity implements View.OnClickListener {

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

    private ACache mACache;

    private String mAddrSpStr = "北京市";

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_address_edit;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

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
        if(mACache.getAsString("addr") != null)
        {
            mAddrSpStr = mACache.getAsString("addr");
        }
    }

    @Override
    public void initEvent() {
        mAddressTopBarBack.setOnClickListener(this);
        mSaveAddress.setOnClickListener(this);
        mDeletaAddress.setOnClickListener(this);
        setSpinnerListeners();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_back:
                finish();
                break;
            case R.id.btn_save_address:
                saveAddress();
                break;
            case R.id.btn_delete_address:
                deleteAddress(addressId);
                break;
            default:
                break;
        }
    }
    private void deleteAddress(String addressId) {

    }

    private void saveAddress() {

    }

    protected void setupViews(Bundle bundle) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
}