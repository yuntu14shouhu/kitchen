package com.jiajiaqian.kitchen.ui.sort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jiajiaqian.kitchen.KitchenApplication;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.ui.ProductSearchActivity;
import com.jiajiaqian.kitchen.ui.ShopActivity;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.shop.ShopProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/4.
 * 子分类列表页面
 */

public class SubSortListActivity extends BaseActivity implements View.OnClickListener, SubSortListAdapter.SortListCallback {

    private ImageButton mBackBtn, mSearchBtn, mShopBtn;
    private TextView mSortNameTv, mShopNumTv;
    private RecyclerView mSubSortListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sort_subsortlist_view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //先判断购物车里是否有添加商品，有的话，topbar要显示商品数量
        if (KitchenApplication.mShopNum != 0) {
            mShopNumTv.setVisibility(View.VISIBLE);
            mShopNumTv.setText(KitchenApplication.mShopNum + "");
        } else {
            mShopNumTv.setVisibility(View.GONE);
        }
        //解析由大分类进入详细分类列表的数据
        Bundle bundle = getIntent().getBundleExtra("sort_list");
        if (bundle != null) {
            List<ProductBean> dataList = (ArrayList<ProductBean>) bundle.getSerializable("sort_list_data");
            if (dataList != null && dataList.size() > 0) {
                SubSortListAdapter subSortListAdapter = new SubSortListAdapter(dataList, R.layout.listitem_subsort_list, this, this);
                mSubSortListView.setAdapter(subSortListAdapter);
            }
        }
        if (getIntent().getStringExtra("sort_name") != null) {
            mSortNameTv.setText(getIntent().getStringExtra("sort_name"));
        }
    }

    @Override
    public void initView() {
        mBackBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mSearchBtn = (ImageButton) this.findViewById(R.id.imgBtn_subSort_search);
        mShopBtn = (ImageButton) this.findViewById(R.id.imageBtn_shop);
        mSortNameTv = (TextView) this.findViewById(R.id.tv_sort_name);
        mShopNumTv = (TextView) this.findViewById(R.id.tv_shop_msg);
        mSubSortListView = (RecyclerView) this.findViewById(R.id.rcy_sub_sort);
        mSubSortListView.setLayoutManager(new LinearLayoutManager(this));
        mSubSortListView.setHasFixedSize(true);
        mSubSortListView.setItemAnimator(new DefaultItemAnimator());
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

    @Override
    public void shopAddClick(ProductBean productBean) {

        KitchenApplication.mShopNum += 1;
        mShopNumTv.setVisibility(View.VISIBLE);
        mShopNumTv.setText(KitchenApplication.mShopNum + "");
    }

    @Override
    public void sortListItemClick(ProductBean productBean) {
        Intent intent = new Intent();
        intent.putExtra("product",productBean);
        intent.setClass(this, ShopProductDetailsActivity.class);
        startActivity(intent);
    }
}
