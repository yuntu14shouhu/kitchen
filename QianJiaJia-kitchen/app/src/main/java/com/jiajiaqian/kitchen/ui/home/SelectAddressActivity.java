package com.jiajiaqian.kitchen.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.common.entity.AddressListBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.common.utils.UserInfoUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.home.adapter.AddressListAdapter;
import com.jiajiaqian.kitchen.ui.personal.PersonalAddressAddActivity;

import org.json.JSONObject;

/**
 * Created by jasonxu on 2017/3/21.
 */

public class SelectAddressActivity extends BaseActivity implements View.OnClickListener,
        AddressListAdapter.AddressCallback {

    private RecyclerView mAddressListView;
    private Button mConfirmBtn, mAddBtn;
    private ImageButton mBackBtn;
    private AddressBean mAddress; //记录adapter中选中的地址

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_select_address;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        if (UserInfoUtils.getUserId(this) != null) {
            KitchenHttpManager.getInstance().getAddressLists(UserInfoUtils.getUserId(this) + "", new OkJsonRequest.OKResponseCallback() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("selectAddress-error", volleyError.getMessage() + "");
                }

                @Override
                public void onResponse(JSONObject jsonObject) {
                    Log.e("selectAddress-success", jsonObject.toString());
                    AddressListBean addressListBean = GsonUtils.jsonToBean(jsonObject.toString(), AddressListBean.class);
                    if (addressListBean.getData() != null && addressListBean.getData().size() > 0) {
                        AddressListAdapter addressListAdapter = new AddressListAdapter(addressListBean.getData(),
                                R.layout.listitem_home_address_list, SelectAddressActivity.this, SelectAddressActivity.this);
                        mAddressListView.setAdapter(addressListAdapter);
                    }
                }
            });
        }
    }

    @Override
    public void initView() {
        mAddressListView = (RecyclerView) this.findViewById(R.id.rcy_address);
        mBackBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mAddBtn = (Button) this.findViewById(R.id.btn_add_address_list);
        mConfirmBtn = (Button) this.findViewById(R.id.btn_add_address_confirm);
        mConfirmBtn.setEnabled(false);
        mConfirmBtn.setClickable(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        mAddressListView.setLayoutManager(linearLayoutManager);
        mAddressListView.setHasFixedSize(true);
        mAddressListView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initEvent() {
        mBackBtn.setOnClickListener(this);
        mConfirmBtn.setOnClickListener(this);
        mAddBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.imgBtn_back:
                finish();
                break;
            case R.id.btn_add_address_list:
                intent = new Intent();
                intent.setClass(this, PersonalAddressAddActivity.class);
                intent.putExtra("address_add_where", "home_address");
                startActivityForResult(intent, 2);
                break;
            case R.id.btn_add_address_confirm:
                if (mAddress != null) {
                    Toast.makeText(this, "选择地址成功", Toast.LENGTH_SHORT).show();
                    intent = new Intent();
                    intent.putExtra("new_address", mAddress.getConsigneeAddress());
                    setResult(1, intent);
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onAddressLSelectClick(AddressBean addressBean, int position) {
        if (addressBean != null) {
            mConfirmBtn.setClickable(true);
            mConfirmBtn.setEnabled(true);
            mConfirmBtn.setBackgroundResource(R.drawable.button_address_checked_shape);
            mAddress = addressBean;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && data != null) {
            if (data.getStringExtra("newAddress") != null) {
                initData(null);
            }
        }
    }
}
