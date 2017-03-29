package com.jiajiaqian.kitchen.ui.shop;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.ShopBean;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.jiajiaqian.kitchen.ui.shop.adapter.ShopFragmentRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonxu on 2017/2/17.
 * 购物车 fragment
 */

public class ShopFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private TextView topBarTitle;
    private Button shoppingNotNullPay;
    private List<ShopBean> mShopBeanList;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ShopFragmentRecycleAdapter adapter;

    public static ShopFragment newInstance(){
        return new ShopFragment();
    }

    @Override
    protected int getLayoutResId() {
//        return R.layout.fragment_tab_shop;//购物车为空时，加载
        return R.layout.fragment_tab_shop_not_null;//购物车不为空时，加载
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        topBarTitle = (TextView) mRootView.findViewById(R.id.top_bar_title);
        topBarTitle.setText("购物车");
        shoppingNotNullPay = (Button) mRootView.findViewById(R.id.bt_shopping_not_null_pay);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.lay_refresh_shopping_not_null);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryPersonal, R.color.colorPrimaryDarkPersonal);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView)mRootView.findViewById(R.id.rcv_shopping_not_null);

        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));


        mShopBeanList = new ArrayList<>();
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product,"麒麟瓜",15,20.0));
        mRecyclerView.setAdapter(adapter = new ShopFragmentRecycleAdapter(getActivity(), R.layout.fragment_tab_shop_not_null_item, mShopBeanList));

    }

    @Override
    protected void initListener() {
        super.initListener();
        shoppingNotNullPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShopAccounts.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                List<ShopBean> results = adapter.getResults();
                results.add(0, new ShopBean(R.drawable.ic_shoppingcart_product,"aa麒麟瓜",15,20.0));
                results.add(0, new ShopBean(R.drawable.ic_shoppingcart_product,"aaaa麒麟瓜",15,20.0));
                adapter.notifyDataSetChanged();
            }
        }, 1000);
    }
}
