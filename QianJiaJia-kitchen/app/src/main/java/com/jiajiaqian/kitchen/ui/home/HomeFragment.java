package com.jiajiaqian.kitchen.ui.home;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.KitchenConstants;
import com.jiajiaqian.kitchen.common.entity.AddressBean;
import com.jiajiaqian.kitchen.common.entity.HomeBean;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.common.entity.microbean.SlideBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.uielements.SwipeRefreshLayout;
import com.jiajiaqian.kitchen.common.utils.GlideImageLoader;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.common.utils.UserInfoUtils;
import com.jiajiaqian.kitchen.ui.LoginActivity;
import com.jiajiaqian.kitchen.ui.ProductDetailsActivity;
import com.jiajiaqian.kitchen.ui.ProductSearchActivity;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.jiajiaqian.kitchen.ui.home.adapter.DiscountAdapter;
import com.jiajiaqian.kitchen.ui.home.adapter.GroupBuyAdapter;
import com.jiajiaqian.kitchen.ui.home.adapter.RecommendAdapter;
import com.yyydjk.library.BannerLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonxu on 2017/2/17.
 * 首页fragment
 */

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        View.OnClickListener {

    private BannerLayout mBanner;
    private RecyclerView mYouHuiListView;
    private RecyclerView mTuanGouListView;
    private RecyclerView mTuiJianListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayout mYouHuiLayout, mTuanGouLayout, mTuiJianLayout;
    private TextView mDefaultAddressView, mYouHuiMoreTv, mTuanGouMoreTv, mTuiJianMoreTv;
    private ImageButton mSearchBtn;
    private List<SlideBean> mSlideDataList; //slide list

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
        mYouHuiLayout = (LinearLayout) mRootView.findViewById(R.id.ll_you_hui);
        mTuanGouLayout = (LinearLayout) mRootView.findViewById(R.id.ll_jin_bao);
        mTuiJianLayout = (LinearLayout) mRootView.findViewById(R.id.ll_ren_qi);
        mYouHuiMoreTv = (TextView) mRootView.findViewById(R.id.tv_youhui_more);
        mTuanGouMoreTv = (TextView) mRootView.findViewById(R.id.tv_tuangou_more);
        mTuiJianMoreTv = (TextView) mRootView.findViewById(R.id.tv_tuijian_more);
        mSearchBtn = (ImageButton) mRootView.findViewById(R.id.imgBtn_search);

        //set views attrs
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getActivity(), 3) {
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
        mTuanGouListView.setLayoutManager(linearLayoutManager);
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
        mYouHuiLayout.setOnClickListener(this);
        mTuanGouLayout.setOnClickListener(this);
        mTuiJianLayout.setOnClickListener(this);
        mYouHuiMoreTv.setOnClickListener(this);
        mTuanGouMoreTv.setOnClickListener(this);
        mTuiJianMoreTv.setOnClickListener(this);
        mDefaultAddressView.setOnClickListener(this);
        mSearchBtn.setOnClickListener(this);

        mBanner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ProductDetailsActivity.class);
                intent.putExtra(KitchenConstants.PRODUCT_INTENT_KEY, KitchenConstants.ProductIntentValue.SLIDE);
                if (mSlideDataList != null && mSlideDataList.size() > 0) {
                    intent.putExtra("slide", mSlideDataList.get(position));
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRefresh() {
        KitchenHttpManager.getInstance().getHomeData("", new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-home--", volleyError.getMessage() + "");
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-home--", jsonObject + "");
                if (jsonObject != null) {
                    HomeBean homeBean = GsonUtils.jsonToBean(jsonObject.toString(), HomeBean.class);
                    if (homeBean.getSlide() != null) {
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

                    if (mSwipeRefreshLayout.isRefreshing()) {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {


        KitchenHttpManager.getInstance().getHomeData("", new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-home--", volleyError.getMessage() + "");
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-home--", jsonObject + "");
                if (jsonObject != null) {
                    HomeBean homeBean = GsonUtils.jsonToBean(jsonObject.toString(), HomeBean.class);
                    if (homeBean.getSlide() != null) {
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

            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ll_you_hui:
                intent = new Intent();
                intent.setClass(getActivity(), DiscountListActivity.class);
                intent.putExtra(KitchenConstants.PRODUCT_LIST_INTENT_KEY, KitchenConstants.ProductListIntentValue.DISCOUNT_LIST);
                startActivity(intent);
                break;
            case R.id.ll_jin_bao:
                intent = new Intent();
                intent.setClass(getActivity(), GroupBuyListActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_ren_qi:
                intent = new Intent();
                intent.setClass(getActivity(), RecommendListActivity.class);
                intent.putExtra(KitchenConstants.PRODUCT_LIST_INTENT_KEY, KitchenConstants.ProductListIntentValue.RECOMMEND_LIST);
                startActivity(intent);
                break;
            case R.id.tv_youhui_more:
                intent = new Intent();
                intent.setClass(getActivity(), DiscountListActivity.class);
                intent.putExtra(KitchenConstants.PRODUCT_LIST_INTENT_KEY, KitchenConstants.ProductListIntentValue.DISCOUNT_LIST);
                startActivity(intent);
                break;
            case R.id.tv_tuangou_more:
                intent = new Intent();
                intent.setClass(getActivity(), GroupBuyListActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_tuijian_more:
                intent = new Intent();
                intent.setClass(getActivity(), RecommendListActivity.class);
                intent.putExtra(KitchenConstants.PRODUCT_LIST_INTENT_KEY, KitchenConstants.ProductListIntentValue.RECOMMEND_LIST);
                startActivity(intent);
                break;
            case R.id.imgBtn_search:
                intent = new Intent();
                intent.setClass(getActivity(), ProductSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_address:
                intent = new Intent();
                if (UserInfoUtils.getUserId(getActivity()) != null) {
                    intent.setClass(getActivity(), SelectAddressActivity.class);
                    startActivityForResult(intent, 1);
                } else { //未登陆去登陆
                    intent.setClass(getActivity(), LoginActivity.class);
                    intent.putExtra("home_address", "home_login");
                    startActivityForResult(intent, 2);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null && data.getStringExtra("new_address") != null) {
            mDefaultAddressView.setText(data.getStringExtra("new_address"));
        } else if (requestCode == 2) {
            //登陆成功回调,重新刷新下页面
            onRefresh();
        }
    }

    private void getAddressData(ArrayList<AddressBean> addressList) {
        if (UserInfoUtils.getUserId(getActivity()) != null) {
            for (AddressBean address : addressList) {
                if (address.getIsDefault() == 1) { //默认地址
                    mDefaultAddressView.setText(address.getConsigneeAddress());
                    break;
                }
            }
        } else {
            mDefaultAddressView.setText("请选择地址");
        }
    }

    private void getSlideData(ArrayList<SlideBean> slideList) {
        List<String> mBannerImageUrls = new ArrayList<>();
        for (SlideBean slide : slideList) {
            mBannerImageUrls.add(slide.getProductImageUrl());
        }
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setViewUrls(mBannerImageUrls);
    }

    private void getDiscountData(ArrayList<ProductBean> discountList) {
        DiscountAdapter discountAdapter = new DiscountAdapter(discountList, R.layout.listitem_home_discount_list, getActivity());
        mYouHuiListView.setAdapter(discountAdapter);
    }

    private void getGroupData(ArrayList<ProductBean> groupList) {
        GroupBuyAdapter groupAdapter = new GroupBuyAdapter(groupList, R.layout.listitem_home_group_list, getActivity());
        mTuanGouListView.setAdapter(groupAdapter);
    }

    private void getRecommendData(ArrayList<ProductBean> recommendList) {
        RecommendAdapter recommendAdapter = new RecommendAdapter(recommendList, R.layout.listitem_home_discount_list, getActivity());
        mTuiJianListView.setAdapter(recommendAdapter);
    }

}
