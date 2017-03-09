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
import com.jiajiaqian.kitchen.ui.base.BaseFragment;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 10:31
 * @Description 用户添加新的收货地址类
 */
public class PersonalAddressAddFragment extends BaseFragment implements View.OnClickListener{

    private TextView mAddressTopBarBack;
    private TextView mAddressTopBarTitle;
    private EditText mInfoAddressNameEt;
    private EditText mInfoAddressPhoneEt;
    private Spinner  mInfoAddressCitySp;
    private EditText mInfoAddressAddressEt;
    private EditText mInfoAddressNumberEt;
    private Button mSaveAddress;
    private Button mDeletaAddress;
    private String addressId;

    private ACache mACache;

    private String mAddrSpStr = "北京市";

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_personal_info_address_edit;
    }

    @Override
    protected void initView() {
        mAddressTopBarBack = (TextView) mRootView.findViewById(R.id.top_bar_back);
        mAddressTopBarTitle = (TextView) mRootView.findViewById(R.id.top_bar_title);
        mInfoAddressNameEt = (EditText) mRootView.findViewById(R.id.et_personal_info_address_name);
        mInfoAddressPhoneEt = (EditText) mRootView.findViewById(R.id.et_personal_info_address_phone);
        mInfoAddressCitySp = (Spinner) mRootView.findViewById(R.id.sp_personal_info_address);
        mInfoAddressAddressEt = (EditText) mRootView.findViewById(R.id.et_personal_info_address_address);
        mInfoAddressNumberEt = (EditText) mRootView.findViewById(R.id.et_personal_info_address_num);
        mSaveAddress = (Button) mRootView.findViewById(R.id.btn_save_address);
        mDeletaAddress = (Button) mRootView.findViewById(R.id.btn_delete_address);

        mACache = ACache.get(getActivity());

        initSpinner();
        initSpinnerText();
    }

    private void initSpinner(){
        ArrayAdapter<String> adapterAddr = new ArrayAdapter<String>(getActivity(), R.layout.personal_myspinner,
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
    protected void initData() {

    }

    @Override
    protected void initListener(){
        super.initListener();
        mAddressTopBarBack.setOnClickListener(this);
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
                getActivity().finish();
            case R.id.btn_save_address:
                saveAddress();
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
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mAddressTopBarTitle.setText("收货地址");
    }
}