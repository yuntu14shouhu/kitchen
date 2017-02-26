package com.jiajiaqian.kitchen.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.common.uielements.SwipeRefreshLayout;
import com.jiajiaqian.kitchen.common.utils.GlideImageLoader;
import com.jiajiaqian.kitchen.common.utils.PicassoImageLoader;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.yyydjk.library.BannerLayout;

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

    private List<String> mBannerImageUrls;
    private HomeGridAdapter mHomeGridAdapter;

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

        //广告轮播翻数据源（网络url或本地地址url）
        mBannerImageUrls = new ArrayList<>();
        mBannerImageUrls.add("http://img3.imgtn.bdimg.com/it/u=2674591031,2960331950&fm=23&gp=0.jpg");
        mBannerImageUrls.add("http://img5.imgtn.bdimg.com/it/u=3639664762,1380171059&fm=23&gp=0.jpg");
        mBannerImageUrls.add("http://img0.imgtn.bdimg.com/it/u=1095909580,3513610062&fm=23&gp=0.jpg");
        mBannerImageUrls.add("http://img4.imgtn.bdimg.com/it/u=1030604573,1579640549&fm=23&gp=0.jpg");
        mBannerImageUrls.add("http://img5.imgtn.bdimg.com/it/u=2583054979,2860372508&fm=23&gp=0.jpg");
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setViewUrls(mBannerImageUrls);

        ProductBean productBean1 = new ProductBean();
        productBean1.setDiscountPrice(34.33);
        productBean1.setDiscountPrice(55.33);
        productBean1.setProductId("32423");

        List<ProductBean> dataList = new ArrayList<>();
        dataList.add(productBean1);
        dataList.add(productBean1);
        dataList.add(productBean1);
        dataList.add(productBean1);
        dataList.add(productBean1);
        dataList.add(productBean1);
        mHomeGridAdapter = new HomeGridAdapter(dataList,R.layout.listitem_home_product_list,getActivity());
        mYouHuiListView.setAdapter(mHomeGridAdapter);
        mTuanGouListView.setAdapter(mHomeGridAdapter);
        mTuiJianListView.setAdapter(mHomeGridAdapter);

    }
}
