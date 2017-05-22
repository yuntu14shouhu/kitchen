package com.jiajiaqian.kitchen.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.ShopBean;
import com.jiajiaqian.kitchen.common.entity.ShopBeanN;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.jiajiaqian.kitchen.ui.personal.PersonalAboutKitchenActivity;
import com.jiajiaqian.kitchen.ui.shop.adapter.ShopFragmentRecycleAdapter;

import org.json.JSONObject;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/2/17.
 * 购物车 fragment
 */

public class ShopFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private TextView topBarTitle;
    private TextView aboutKitchen;
    private TextView totalPayTv;
    private Button shoppingNotNullPay;
    private List<ShopBean> mShopBeanList;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ShopFragmentRecycleAdapter adapter;

    private ShopBeanN mShopBeanN;

    private double mTotal;
    private ShopFragmentRecycleAdapter mAdapter;

    public ShopFragment() {
        mTotal = 0;
    }


    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getShopList();
    }

    @Override
    protected int getLayoutResId() {
        if (mShopBeanN!=null){
            if (mShopBeanN.getData() == null || mShopBeanN.getData().size() == 0){
                return R.layout.fragment_tab_shop;//购物车为空时，加载
            }else {
                return R.layout.fragment_tab_shop_not_null;//购物车不为空时，加载
            }
        }else {
            return R.layout.fragment_tab_shop_not_null;//购物车为空时，加载
        }
    }


    @Override
    protected void initView() {
//        if(mShopBeanN != null){
//
//        }
        topBarTitle = (TextView) mRootView.findViewById(R.id.shopping_not_null_include).findViewById(R.id.top_bar_title);
        topBarTitle.setText("购物车");
        totalPayTv = (TextView) mRootView.findViewById(R.id.tv_shopping_not_null_total);
        totalPayTv.setText(mTotal+"");
        aboutKitchen = (TextView) mRootView.findViewById(R.id.tv_shopping_nou_null);
        shoppingNotNullPay = (Button) mRootView.findViewById(R.id.bt_shopping_not_null_pay);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.lay_refresh_shopping_not_null);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryPersonal, R.color.colorPrimaryDarkPersonal);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.rcv_shopping_not_null);

        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
        if (mShopBeanN==null){
            mShopBeanN = new ShopBeanN();
        }
    }

    @Override
    protected void initData() {


//        mShopBeanList = new ArrayList<>();
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mShopBeanList.add(new ShopBean(R.drawable.ic_shoppingcart_product, "麒麟瓜", 15, 20.0));
//        mRecyclerView.setAdapter(adapter = new ShopFragmentRecycleAdapter(getActivity(), R.layout.fragment_tab_shop_not_null_item, mShopBeanList));

    }

    @Override
    protected void initListener() {
        super.initListener();
        shoppingNotNullPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShopAccountsActivity.class);
                startActivity(intent);
            }
        });

        aboutKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PersonalAboutKitchenActivity.class);
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
                getShopList();
            }
        }, 1000);
    }


    public void getShopList(){

        KitchenHttpManager.getInstance().getShopList( new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-shop-list-", volleyError.getMessage() + "");
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-shop-list-", jsonObject + "");
                if (jsonObject != null) {
                    mShopBeanN = GsonUtils.jsonToBean(jsonObject.toString(),ShopBeanN.class);
                    totalPay(mShopBeanN.getData());
                    Log.e("data", "onResponse: "+mShopBeanN.getData() );
                    if (mShopBeanN.getData()!=null)
                        getShopListData(mShopBeanN.getData());
                }
            }
        });

    }

    private void getShopListData(List<ShopBeanN.DataBean> data) {
        mAdapter = new ShopFragmentRecycleAdapter(getActivity(), R.layout.fragment_tab_shop_not_null_item, data);
        mAdapter.setShopAdapterCall(new ShopFragmentRecycleAdapter.ShopAdapterCall() {
            @Override
            public void dealNumChanged(List<ShopBeanN.DataBean> results) {
                totalPay(results);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public double totalPay(List<ShopBeanN.DataBean> dataBeanList){
        mTotal = 0;
        if(dataBeanList != null && dataBeanList.size() > 0){
            for (ShopBeanN.DataBean data : dataBeanList){
                double price = data.getPrice();
                int proNum = data.getProductNumber();
                price = proNum * price;
                mTotal = mTotal + price;
            }
        }
        totalPayTv.setText(mTotal+"");
        return mTotal;
    }

}
