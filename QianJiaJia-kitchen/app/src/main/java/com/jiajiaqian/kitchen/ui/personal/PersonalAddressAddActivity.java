package com.jiajiaqian.kitchen.ui.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

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

    private String addrSpStr = "成都市";
    private ACache mACache;

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
        if(mACache.getAsString("addr") != null)
        {
            addrSpStr = mACache.getAsString("addr");
        }
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(this);
        addressSave.setOnClickListener(this);
        setSpinnerListeners();
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
        switch (v.getId()){
            case R.id.top_bar_back:
                finish();
                break;
            case R.id.btn_save_address_add:
                addressSave();
                break;
                default:
                    break;
        }
    }

    private void addressSave() {
    }
}