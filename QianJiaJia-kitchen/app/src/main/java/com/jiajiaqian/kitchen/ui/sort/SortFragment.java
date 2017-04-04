package com.jiajiaqian.kitchen.ui.sort;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.SortBean;
import com.jiajiaqian.kitchen.common.entity.SortListBean;
import com.jiajiaqian.kitchen.common.entity.microbean.EggBean;
import com.jiajiaqian.kitchen.common.entity.microbean.FishBean;
import com.jiajiaqian.kitchen.common.entity.microbean.FoodBean;
import com.jiajiaqian.kitchen.common.entity.microbean.FruitBean;
import com.jiajiaqian.kitchen.common.entity.microbean.MeatBean;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.common.entity.microbean.VegetableBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonxu on 2017/2/17.
 * 分类 fragment
 */

public class SortFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout mSearchLayout, mVegetableLayout, mFruitLayout, mMeatLayout, mEggLayout, mFishLayout, mFoodLayout;
    private ImageView mVegetableImg, mFruitImg, mMeatImg, mEggImg, mFishImg, mFoodImg;
    private TextView mVegetableTv, mFruitTv, mMeatTv, mEggTv, mFishTv, mFoodTv;
    private RecyclerView mSortRcyView;
    private List<SortListBean> mVegetableSortList; //记录蔬菜分类的list
    private List<SortListBean> mFruitSortList; //记录水果分类的list
    private List<SortListBean> mMeatSortList; //记录肉类分类的list
    private List<SortListBean> mEggSortList; //记录禽蛋分类的list
    private List<SortListBean> mFishSortList; //记录水产分类的list
    private List<SortListBean> mFoodSortList; //记录粮食分类的list

    public static SortFragment newInstance() {
        return new SortFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tab_sort;
    }

    @Override
    protected void initView() {
        mSearchLayout = (LinearLayout) mRootView.findViewById(R.id.top_search);
        mVegetableLayout = (LinearLayout) mRootView.findViewById(R.id.ll_shuCai);
        mFruitLayout = (LinearLayout) mRootView.findViewById(R.id.ll_shuiGuo);
        mMeatLayout = (LinearLayout) mRootView.findViewById(R.id.ll_rouLei);
        mEggLayout = (LinearLayout) mRootView.findViewById(R.id.ll_qinDan);
        mFishLayout = (LinearLayout) mRootView.findViewById(R.id.ll_shuiChan);
        mFoodLayout = (LinearLayout) mRootView.findViewById(R.id.ll_liangYou);
        mVegetableImg = (ImageView) mRootView.findViewById(R.id.img_shuCai);
        mFruitImg = (ImageView) mRootView.findViewById(R.id.img_shuiGuo);
        mMeatImg = (ImageView) mRootView.findViewById(R.id.img_rouLei);
        mEggImg = (ImageView) mRootView.findViewById(R.id.img_qinDan);
        mFishImg = (ImageView) mRootView.findViewById(R.id.img_shuiChan);
        mFoodImg = (ImageView) mRootView.findViewById(R.id.img_liangYou);
        mVegetableTv = (TextView) mRootView.findViewById(R.id.tv_shuCai);
        mFruitTv = (TextView) mRootView.findViewById(R.id.tv_shuiGuo);
        mMeatTv = (TextView) mRootView.findViewById(R.id.tv_rouLei);
        mEggTv = (TextView) mRootView.findViewById(R.id.tv_qinDan);
        mFishTv = (TextView) mRootView.findViewById(R.id.tv_shuiChan);
        mFoodTv = (TextView) mRootView.findViewById(R.id.tv_liangYou);
        mSortRcyView = (RecyclerView) mRootView.findViewById(R.id.rcy_sort);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mSortRcyView.setLayoutManager(gridLayoutManager);
        mSortRcyView.setHasFixedSize(true);
        mSortRcyView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mVegetableLayout.setOnClickListener(this);
        mFruitLayout.setOnClickListener(this);
        mMeatLayout.setOnClickListener(this);
        mEggLayout.setOnClickListener(this);
        mFishLayout.setOnClickListener(this);
        mFoodLayout.setOnClickListener(this);

        //让蔬菜按钮默认点击
        mVegetableLayout.performClick();
    }

    @Override
    protected void initData() {

        KitchenHttpManager.getInstance().getSortData("", new OkJsonRequest.OKResponseCallback() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-sort--", jsonObject + "");
                SortBean sortBean = GsonUtils.jsonToBean(jsonObject.toString(), SortBean.class);
                //处理分类列表的数据
                if (sortBean != null) {
                    detailSortData(sortBean);
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-sort--", volleyError.getMessage() + "");
            }

        });
    }

    @Override
    public void onClick(View view) {
        //变换点击不同按钮的view状态
        changeViewState(view);
        //对各个点击按钮的不同监听操作
        switch (view.getId()) {
            case R.id.ll_shuCai:
                if (mVegetableSortList != null && mVegetableSortList.size() > 0) {
                    SortGridAdapter sortGridAdapter = new SortGridAdapter(mVegetableSortList, R.layout.listitem_sort_category_list, getActivity());
                    mSortRcyView.setAdapter(sortGridAdapter);
                }
                break;
            case R.id.ll_shuiGuo:
                if (mFruitSortList != null && mFruitSortList.size() > 0) {
                    SortGridAdapter sortGridAdapter = new SortGridAdapter(mFruitSortList, R.layout.listitem_sort_category_list, getActivity());
                    mSortRcyView.setAdapter(sortGridAdapter);
                }
                break;
            case R.id.ll_rouLei:
                if (mMeatSortList != null && mMeatSortList.size() > 0) {
                    SortGridAdapter sortGridAdapter = new SortGridAdapter(mMeatSortList, R.layout.listitem_sort_category_list, getActivity());
                    mSortRcyView.setAdapter(sortGridAdapter);
                }
                break;
            case R.id.ll_qinDan:
                if (mEggSortList != null && mEggSortList.size() > 0) {
                    SortGridAdapter sortGridAdapter = new SortGridAdapter(mEggSortList, R.layout.listitem_sort_category_list, getActivity());
                    mSortRcyView.setAdapter(sortGridAdapter);
                }
                break;
            case R.id.ll_shuiChan:
                if (mFishSortList != null && mFishSortList.size() > 0) {
                    SortGridAdapter sortGridAdapter = new SortGridAdapter(mFishSortList, R.layout.listitem_sort_category_list, getActivity());
                    mSortRcyView.setAdapter(sortGridAdapter);
                }
                break;
            case R.id.ll_liangYou:
                if (mFoodSortList != null && mFoodSortList.size() > 0) {
                    SortGridAdapter sortGridAdapter = new SortGridAdapter(mFoodSortList, R.layout.listitem_sort_category_list, getActivity());
                    mSortRcyView.setAdapter(sortGridAdapter);
                }
                break;
            default:
                break;
        }
    }

    private void initViewState() {
        mVegetableTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_dark));
        mFruitTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_dark));
        mMeatTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_dark));
        mEggTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_dark));
        mFishTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_dark));
        mFoodTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_dark));
        mVegetableLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mFruitLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mMeatLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mEggLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mFishLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mFoodLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mVegetableTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mFruitTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mMeatTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mEggTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mFishTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mFoodTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_white));
        mVegetableImg.setVisibility(View.GONE);
        mFruitImg.setVisibility(View.GONE);
        mMeatImg.setVisibility(View.GONE);
        mEggImg.setVisibility(View.GONE);
        mFishImg.setVisibility(View.GONE);
        mFoodImg.setVisibility(View.GONE);
    }

    private void changeViewState(View view) {
        initViewState();
        switch (view.getId()) {
            case R.id.ll_shuCai:
                mVegetableTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_yellow));
                mVegetableLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mVegetableTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mVegetableImg.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_shuiGuo:
                mFruitTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_yellow));
                mFruitLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mFruitTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mFruitImg.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_rouLei:
                mMeatTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_yellow));
                mMeatLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mMeatTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mMeatImg.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_qinDan:
                mEggTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_yellow));
                mEggLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mEggTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mEggImg.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_shuiChan:
                mFishTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_yellow));
                mFishLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mFishTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mFishImg.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_liangYou:
                mFoodTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.con_yellow));
                mFoodLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mFoodTv.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.con_font_gray2));
                mFoodImg.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void detailSortData(SortBean sortBean) {
        //处理蔬菜类的数据
        if (sortBean.getVegetable() != null) {
            mVegetableSortList = new ArrayList<>();
            detailVegetableData(sortBean.getVegetable());
            //当第一次进入分类页面时，默认会自动点击蔬菜分类按钮，但如果此时网络数据没有获取完成或者没有处理完成，mVegetableSortList将为null，就不会
            //显示蔬菜分类的数据，所以此处是避免该情况发生
            if (mVegetableSortList != null && mVegetableSortList.size() > 0) {
                SortGridAdapter sortGridAdapter = new SortGridAdapter(mVegetableSortList, R.layout.listitem_sort_category_list, getActivity());
                mSortRcyView.setAdapter(sortGridAdapter);
            }
        }
        //处理水果类的数据
        if (sortBean.getFruit() != null) {
            mFruitSortList = new ArrayList<>();
            detailFruitData(sortBean.getFruit());
        }

        //处理肉类的数据
        if (sortBean.getMeat() != null) {
            mMeatSortList = new ArrayList<>();
            detailMeatData(sortBean.getMeat());
        }

        //处理禽蛋类的数据
        if (sortBean.getEgg() != null) {
            mEggSortList = new ArrayList<>();
            detailEggData(sortBean.getEgg());
        }

        //处理水产类的数据
        if (sortBean.getFish() != null) {
            mFishSortList = new ArrayList<>();
            detailFishData(sortBean.getFish());
        }

        //处理粮油副食类的数据
        if (sortBean.getFood() != null) {
            mFoodSortList = new ArrayList<>();
            detailFoodData(sortBean.getFood());
        }
    }

    private void detailVegetableData(VegetableBean vegetableBean) {
        SortListBean sortListBean;
        //判断是否有这个字段或者该字段有数据才显示该分类
        if (vegetableBean.getDouZhiPin() != null && vegetableBean.getDouZhiPin().size() > 0) {
            //用list中的第一个商品imageUrl作为分类列表的图片展示
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getDouZhiPin().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.dou_zhi_pin));
            sortListBean.setSortList(vegetableBean.getDouZhiPin());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getGenJingLei() != null && vegetableBean.getGenJingLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getGenJingLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.gen_jing_lei));
            sortListBean.setSortList(vegetableBean.getGenJingLei());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getJingPinShuCai() != null && vegetableBean.getJingPinShuCai().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getJingPinShuCai().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.jing_pin_shu_cai));
            sortListBean.setSortList(vegetableBean.getJingPinShuCai());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getJingShiShu() != null && vegetableBean.getJingShiShu().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getJingShiShu().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.jing_shi_shu));
            sortListBean.setSortList(vegetableBean.getJingShiShu());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getJunGuLei() != null && vegetableBean.getJunGuLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getJunGuLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.jun_gu_lei));
            sortListBean.setSortList(vegetableBean.getJunGuLei());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getQieGuoLei() != null && vegetableBean.getQieGuoLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getQieGuoLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.qie_guo_lei));
            sortListBean.setSortList(vegetableBean.getQieGuoLei());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getShiLingShuCai() != null && vegetableBean.getShiLingShuCai().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getShiLingShuCai().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.shi_ling_shu_cai));
            sortListBean.setSortList(vegetableBean.getShiLingShuCai());
            mVegetableSortList.add(sortListBean);
        }
        if (vegetableBean.getYeCaiLei() != null && vegetableBean.getYeCaiLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(vegetableBean.getYeCaiLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.ye_cai_lei));
            sortListBean.setSortList(vegetableBean.getYeCaiLei());
            mVegetableSortList.add(sortListBean);
        }
    }

    private void detailFruitData(FruitBean fruitBean) {
        SortListBean sortListBean;
        if (fruitBean.getGanJuChengYou() != null && fruitBean.getGanJuChengYou().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getGanJuChengYou().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.gan_ju_cheng_you));
            sortListBean.setSortList(fruitBean.getGanJuChengYou());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getNiuYouGuo() != null && fruitBean.getNiuYouGuo().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getNiuYouGuo().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.niu_you_guo));
            sortListBean.setSortList(fruitBean.getNiuYouGuo());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getPingGuoLi() != null && fruitBean.getPingGuoLi().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getPingGuoLi().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.ping_guo_li));
            sortListBean.setSortList(fruitBean.getPingGuoLi());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getPuTaoTiZi() != null && fruitBean.getPuTaoTiZi().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getPuTaoTiZi().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.pu_tao_ti_zi));
            sortListBean.setSortList(fruitBean.getPuTaoTiZi());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getQiYiGuo() != null && fruitBean.getQiYiGuo().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getQiYiGuo().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.qi_yi_guo));
            sortListBean.setSortList(fruitBean.getQiYiGuo());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getReDaiShuiGuo() != null && fruitBean.getReDaiShuiGuo().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getReDaiShuiGuo().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.re_dai_shui_guo));
            sortListBean.setSortList(fruitBean.getReDaiShuiGuo());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getShiLingShuiGuo() != null && fruitBean.getShiLingShuiGuo().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getShiLingShuiGuo().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.shi_ling_shui_guo));
            sortListBean.setSortList(fruitBean.getShiLingShuiGuo());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getXiangJiao() != null && fruitBean.getXiangJiao().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getXiangJiao().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.xiang_jiao));
            sortListBean.setSortList(fruitBean.getXiangJiao());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getYeQing() != null && fruitBean.getYeQing().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getYeQing().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.ye_qing));
            sortListBean.setSortList(fruitBean.getYeQing());
            mFruitSortList.add(sortListBean);
        }
        if (fruitBean.getYeZi() != null && fruitBean.getYeZi().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fruitBean.getYeZi().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.ye_zi));
            sortListBean.setSortList(fruitBean.getYeZi());
            mFruitSortList.add(sortListBean);
        }
    }

    private void detailMeatData(MeatBean meatBean) {
        SortListBean sortListBean;
        if (meatBean.getNiuPai() != null && meatBean.getNiuPai().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(meatBean.getNiuPai().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.niu_pai));
            sortListBean.setSortList(meatBean.getNiuPai());
            mMeatSortList.add(sortListBean);
        }
        if (meatBean.getNiuRou() != null && meatBean.getNiuRou().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(meatBean.getNiuRou().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.niu_rou));
            sortListBean.setSortList(meatBean.getNiuRou());
            mMeatSortList.add(sortListBean);
        }
        if (meatBean.getRouZhiPin() != null && meatBean.getRouZhiPin().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(meatBean.getRouZhiPin().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.rou_zhi_pin));
            sortListBean.setSortList(meatBean.getRouZhiPin());
            mMeatSortList.add(sortListBean);
        }
        if (meatBean.getXinXianRou() != null && meatBean.getXinXianRou().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(meatBean.getXinXianRou().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.xin_xian_rou));
            sortListBean.setSortList(meatBean.getXinXianRou());
            mMeatSortList.add(sortListBean);
        }
        if (meatBean.getYangRou() != null && meatBean.getYangRou().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(meatBean.getYangRou().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.yang_rou));
            sortListBean.setSortList(meatBean.getYangRou());
            mMeatSortList.add(sortListBean);
        }
        if (meatBean.getZhuRou() != null && meatBean.getZhuRou().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(meatBean.getZhuRou().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.zhu_rou));
            sortListBean.setSortList(meatBean.getZhuRou());
            mMeatSortList.add(sortListBean);
        }
    }

    private void detailEggData(EggBean eggBean) {
        SortListBean sortListBean;
        if (eggBean.getJiaGongDan() != null && eggBean.getJiaGongDan().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(eggBean.getJiaGongDan().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.jia_gong_dan));
            sortListBean.setSortList(eggBean.getJiaGongDan());
            mEggSortList.add(sortListBean);
        }
        if (eggBean.getJiYaBuJian() != null && eggBean.getJiYaBuJian().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(eggBean.getJiYaBuJian().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.ji_ya_bu_jian));
            sortListBean.setSortList(eggBean.getJiYaBuJian());
            mEggSortList.add(sortListBean);
        }
        if (eggBean.getJiYaZhengQin() != null && eggBean.getJiYaZhengQin().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(eggBean.getJiYaZhengQin().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.ji_ya_zheng_qin));
            sortListBean.setSortList(eggBean.getJiYaZhengQin());
            mEggSortList.add(sortListBean);
        }
        if (eggBean.getXianDan() != null && eggBean.getXianDan().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(eggBean.getXianDan().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.xian_dan));
            sortListBean.setSortList(eggBean.getXianDan());
            mEggSortList.add(sortListBean);
        }
    }

    private void detailFishData(FishBean fishBean) {
        SortListBean sortListBean;
        if (fishBean.getBeiKeLei() != null && fishBean.getBeiKeLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fishBean.getBeiKeLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.bei_ke_lei));
            sortListBean.setSortList(fishBean.getBeiKeLei());
            mFishSortList.add(sortListBean);
        }
        if (fishBean.getDanShuiYu() != null && fishBean.getDanShuiYu().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fishBean.getDanShuiYu().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.dan_shui_yu));
            sortListBean.setSortList(fishBean.getDanShuiYu());
            mFishSortList.add(sortListBean);
        }
        if (fishBean.getHaiShuiYu() != null && fishBean.getHaiShuiYu().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fishBean.getHaiShuiYu().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.hai_shui_yu));
            sortListBean.setSortList(fishBean.getHaiShuiYu());
            mFishSortList.add(sortListBean);
        }
        if (fishBean.getXiaXieLei() != null && fishBean.getXiaXieLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(fishBean.getXiaXieLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.xia_xie_lei));
            sortListBean.setSortList(fishBean.getXiaXieLei());
            mFishSortList.add(sortListBean);
        }
    }

    private void detailFoodData(FoodBean foodBean) {
        SortListBean sortListBean;
        if (foodBean.getMiMianZaLiang() != null && foodBean.getMiMianZaLiang().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(foodBean.getMiMianZaLiang().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.mi_mian_za_liang));
            sortListBean.setSortList(foodBean.getMiMianZaLiang());
            mFoodSortList.add(sortListBean);
        }
        if (foodBean.getNanBeiGanHuo() != null && foodBean.getNanBeiGanHuo().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(foodBean.getNanBeiGanHuo().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.nan_bei_gan_huo));
            sortListBean.setSortList(foodBean.getNanBeiGanHuo());
            mFoodSortList.add(sortListBean);
        }
        if (foodBean.getShiYongYou() != null && foodBean.getShiYongYou().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(foodBean.getShiYongYou().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.shi_yong_you));
            sortListBean.setSortList(foodBean.getShiYongYou());
            mFoodSortList.add(sortListBean);
        }
        if (foodBean.getTiaoWeiFenLei() != null && foodBean.getTiaoWeiFenLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(foodBean.getTiaoWeiFenLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.tiao_wei_fen_lei));
            sortListBean.setSortList(foodBean.getTiaoWeiFenLei());
            mFoodSortList.add(sortListBean);
        }
        if (foodBean.getTiaoWeiJiangLei() != null && foodBean.getTiaoWeiJiangLei().size() > 0) {
            sortListBean = new SortListBean();
            sortListBean.setSortImageUrl(foodBean.getTiaoWeiJiangLei().get(0).getProductImageUrl());
            sortListBean.setSortName(getString(R.string.tiao_wei_jiang_lei));
            sortListBean.setSortList(foodBean.getTiaoWeiJiangLei());
            mFoodSortList.add(sortListBean);
        }
    }
}


