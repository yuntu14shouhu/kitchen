package com.jiajiaqian.kitchen.ui.home;

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
import com.jiajiaqian.kitchen.common.entity.ProductListBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.home.adapter.DiscountListAdapter;
import com.jiajiaqian.kitchen.ui.home.adapter.GroupBuyListAdapter;

import org.json.JSONObject;

/**
 * Created by jasonxu on 2017/4/5.
 */

public class GroupBuyListActivity extends BaseActivity {

    private ImageButton mBackBtn;
    private RecyclerView mGroupBuyListView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_group_list;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        KitchenHttpManager.getInstance().getJinBaoLists(new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                ProductListBean productListBean = GsonUtils.jsonToBean(jsonObject.toString(),ProductListBean.class);
                if (productListBean.getData() != null && productListBean.getData().size()>0){
                    GroupBuyListAdapter groupBuyListAdapter = new GroupBuyListAdapter(productListBean.getData(),R.layout.listitem_home_group_sub_list,GroupBuyListActivity.this);
                    mGroupBuyListView.setAdapter(groupBuyListAdapter);
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("group_list_error","volleyError: "+volleyError.getMessage());
            }
        });
    }

    @Override
    public void initView() {
        mBackBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mGroupBuyListView = (RecyclerView) this.findViewById(R.id.rcy_group_buy);
        mGroupBuyListView.setHasFixedSize(true);
        mGroupBuyListView.setItemAnimator(new DefaultItemAnimator());
        mGroupBuyListView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initEvent() {
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
