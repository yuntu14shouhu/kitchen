package com.jiajiaqian.kitchen.ui.home;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.common.entity.HomeBean;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.common.entity.microbean.SlideBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpApi;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.uielements.SwipeRefreshLayout;
import com.jiajiaqian.kitchen.common.utils.GlideImageLoader;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.yyydjk.library.BannerLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonxu on 2017/2/17.
 * 首页fragment
 */

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private BannerLayout mBanner;
    private RecyclerView mYouHuiListView;
    private RecyclerView mTuanGouListView;
    private RecyclerView mTuiJianListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mDefaultAddressView;

    private KitchenHttpApi<OkJsonRequest.OKResponseCallback> mKitchenHttpManger;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tab_home;
    }

    @Override
    protected void initView() {
        mBanner = (BannerLayout) mRootView.findViewById(R.id.banner);
        mYouHuiListView = (RecyclerView) mRootView.findViewById(R.id.rcy_youhui);
        mTuanGouListView = (RecyclerView) mRootView.findViewById(R.id.rcy_tuangou);
        mTuiJianListView = (RecyclerView) mRootView.findViewById(R.id.rcy_tuijian);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.swipeRefreshLayout);
        mDefaultAddressView = (TextView) mRootView.findViewById(R.id.tv_address);

        //set views attrs
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(),3){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(),3){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        mYouHuiListView.setLayoutManager(gridLayoutManager);
        mYouHuiListView.setHasFixedSize(true);
        mYouHuiListView.setItemAnimator(new DefaultItemAnimator());
        mTuanGouListView.setLayoutManager(gridLayoutManager2);
        mTuanGouListView.setHasFixedSize(true);
        mTuanGouListView.setItemAnimator(new DefaultItemAnimator());
        mTuiJianListView.setLayoutManager(gridLayoutManager3);
        mTuiJianListView.setHasFixedSize(true);
        mTuiJianListView.setItemAnimator(new DefaultItemAnimator());
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
    }

    @Override
    protected void initListener() {
        super.initListener();

        mSwipeRefreshLayout.setOnRefreshListener(this);

        mBanner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onRefresh() {

    }

    @Override
    protected void initData() {

        mKitchenHttpManger = KitchenHttpManager.getInstance();

        mKitchenHttpManger.getHomeData("", new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-home--",volleyError.getMessage()+"");
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-home--",jsonObject+"");
                HomeBean homeBean = GsonUtils.jsonToBean(jsonObject.toString(),HomeBean.class);
                if (homeBean.getSlide() != null){
                    getSlideData(homeBean.getSlide());
                }
                if (homeBean.getAddress() != null) {
                    getAddressData(homeBean.getAddress());
                }
                if (homeBean.getDiscount() != null) {
                    getDiscountData(homeBean.getDiscount());
                }

                if (homeBean.getGroup() != null) {
                    getGroupData(homeBean.getGroup());
                }

                if (homeBean.getRecommend() != null) {
                    getRecommendData(homeBean.getRecommend());
                }

            }
        });

    }

    private void getAddressData(ArrayList<AddressBean> addressList){
        for (AddressBean address : addressList){
            if (address.getIsDefault() == 1){ //默认地址
                mDefaultAddressView.setText(address.getConsigneeAddress());
            }
        }
    }

    private void getSlideData(ArrayList<SlideBean> slideList){
        List<String> mBannerImageUrls = new ArrayList<>();
        for (SlideBean slide : slideList) {
            mBannerImageUrls.add(slide.getProductImageUrl());
        }
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setViewUrls(mBannerImageUrls);
    }

    private void getDiscountData(ArrayList<ProductBean> discountList) {
        HomeGridAdapter discountAdapter = new HomeGridAdapter(discountList,R.layout.listitem_home_product_list,getActivity());
        mYouHuiListView.setAdapter(discountAdapter);
    }

    private void getGroupData(ArrayList<ProductBean> groupList) {
        HomeGridAdapter groupAdapter = new HomeGridAdapter(groupList,R.layout.listitem_home_product_list,getActivity());
        mTuanGouListView.setAdapter(groupAdapter);
    }

    private void getRecommendData(ArrayList<ProductBean> recommendList) {
        HomeGridAdapter recommendAdapter = new HomeGridAdapter(recommendList,R.layout.listitem_home_product_list,getActivity());
        mTuiJianListView.setAdapter(recommendAdapter);
    }

}
