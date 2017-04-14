package com.jiajiaqian.kitchen.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.KitchenConstants;
import com.jiajiaqian.kitchen.common.entity.ProductListBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.ProductSearchActivity;
import com.jiajiaqian.kitchen.ui.ShopActivity;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.home.adapter.DiscountListAdapter;

import org.json.JSONObject;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/5.
 */

public class DiscountListActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView mYouHuiListView;
    private ImageButton mBackBtn, mSearchBtn, mShopBtn;
    private TextView mSortNameTv, mShopNumTv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sort_subsortlist_view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (getIntent().getStringExtra(KitchenConstants.PRODUCT_LIST_INTENT_KEY) != null
                && getIntent().getStringExtra(KitchenConstants.PRODUCT_LIST_INTENT_KEY).equals(KitchenConstants.ProductListIntentValue.DISCOUNT_LIST)){
            mSortNameTv.setText("优惠商品");
        }
        KitchenHttpManager.getInstance().getYouHuiLists(new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                ProductListBean productListBean = GsonUtils.jsonToBean(jsonObject.toString(),ProductListBean.class);
                if (productListBean.getData() != null && productListBean.getData().size()>0){
                    DiscountListAdapter discountListAdapter = new DiscountListAdapter(productListBean.getData(),R.layout.listitem_subsort_list,DiscountListActivity.this);
                    mYouHuiListView.setAdapter(discountListAdapter);
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("youhui_list_error","volleyError: "+volleyError.getMessage());
            }
        });
    }

    @Override
    public void initView() {
        mBackBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mSearchBtn = (ImageButton) this.findViewById(R.id.imgBtn_subSort_search);
        mShopBtn = (ImageButton) this.findViewById(R.id.imageBtn_shop);
        mSortNameTv = (TextView) this.findViewById(R.id.tv_sort_name);
        mShopNumTv = (TextView) this.findViewById(R.id.tv_shop_msg);
        mYouHuiListView = (RecyclerView) this.findViewById(R.id.rcy_sub_sort);
        mYouHuiListView.setLayoutManager(new LinearLayoutManager(this));
        mYouHuiListView.setItemAnimator(new DefaultItemAnimator());
        mYouHuiListView.setHasFixedSize(true);
    }

    @Override
    public void initEvent() {
        mBackBtn.setOnClickListener(this);
        mSearchBtn.setOnClickListener(this);
        mShopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.imgBtn_back:
                finish();
                break;
            case R.id.imgBtn_subSort_search:
                intent = new Intent();
                intent.setClass(this, ProductSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.imageBtn_shop:
                intent = new Intent();
                intent.setClass(this, ShopActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
