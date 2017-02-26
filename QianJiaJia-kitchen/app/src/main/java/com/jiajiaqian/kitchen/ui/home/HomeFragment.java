package com.jiajiaqian.kitchen.ui.home;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.jiajiaqian.kitchen.R;
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

public class HomeFragment extends BaseFragment {

    private BannerLayout mBanner;

    private List<String> mBannerImageUrls;

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tab_home;
    }

    @Override
    protected void initView() {

        mBanner = (BannerLayout) mRootView.findViewById(R.id.banner);
    }

    @Override
    protected void initListener() {
        super.initListener();

        mBanner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });

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
    }
}
