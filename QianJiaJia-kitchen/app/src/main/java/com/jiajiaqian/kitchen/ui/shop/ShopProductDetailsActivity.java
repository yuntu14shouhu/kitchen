package com.jiajiaqian.kitchen.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.ProductDetailsQueryBean;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductDetailsBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.MainActivity;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 商品详情查看
 * @Date 2017-03-23 23:14
 * @email qianjiajia_2013@126.com
 * shift+f6
 */
public class ShopProductDetailsActivity extends BaseActivity {

    private TextView topBarBack;
    private ImageView numberPlus;
    private ImageView numberMinus;
    private ProductDetailsBean mProductDetailsBean = new ProductDetailsBean();
    private Button addShopCart;
    private TextView nameProductDetails;
    private TextView smallClassProductDetails;
    private TextView priceProductDetails;
    private TextView mCountTv;
    private TextView namePinProductDetails;
    private TextView addressProductDetails;
    private TextView putawayProductDetails;
    private TextView typeProductDetails;
    private TextView manufactureDateProductDetails;
    private TextView describedProductdetails;
    private ImageView shopShowProductDetails;
    private ImageView productDetailsIv;
    private TextView moreTv;
    private PopupWindow mPopWindow;
    private Button popupBt;

    private CustomToast toast;


    @Override
    public int getLayoutId() {
        return R.layout.activity_shoppingcart_product_details;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Intent it = getIntent();
        KitchenHttpManager.getInstance().getProductDetails(it.getStringExtra("productId"), new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-order-details--", jsonObject + "");
                if (jsonObject != null) {
                    ProductDetailsQueryBean productDetailsQueryBean = GsonUtils.jsonToBean(jsonObject.toString(), ProductDetailsQueryBean.class);
                    if (productDetailsQueryBean.getData() != null) {
                        getProductDetailsData(productDetailsQueryBean.getData());
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-order--details--", volleyError.getMessage() + "");
            }
        });
    }

    private void getProductDetailsData(ProductBean data) {

        Glide.with(this)
                .load(data.getProductImageUrl())
                .centerCrop()
                .into(productDetailsIv);
        nameProductDetails.setText(data.getProductName());
        smallClassProductDetails.setText(data.getKeyClass());
        priceProductDetails.setText(data.getPrice()+"");
        mCountTv.setText(data.getLimitNumber()+"");
        namePinProductDetails.setText(data.getProductName());
        addressProductDetails.setText(data.getAddress());
        putawayProductDetails.setText(getStrTime(data.getPutawayDate()+""));
        typeProductDetails.setText(data.getProductTypes());
        manufactureDateProductDetails.setText(getStrTime(data.getProductionDate()+""));
        describedProductdetails.setText(data.getDescribed());

    }

    @Override
    public void initView() {
        moreTv = (TextView) findViewById(R.id.tv_more);
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        numberPlus = (ImageView) findViewById(R.id.iv_plus_product_details);
        numberMinus = (ImageView) findViewById(R.id.iv_minus_product_details);
        productDetailsIv = (ImageView) findViewById(R.id.iv_product_details);
        addShopCart = (Button) findViewById(R.id.bt_product_details_add);
        nameProductDetails = (TextView) findViewById(R.id.tv_product_name_details);
        smallClassProductDetails = (TextView) findViewById(R.id.tv_product_small_class_name_details);
        priceProductDetails = (TextView) findViewById(R.id.tv_product_one_price_details);
        mCountTv = (TextView) findViewById(R.id.tv_number_product_details);
        namePinProductDetails = (TextView) findViewById(R.id.tv_pinming_context_product_details);
        addressProductDetails = (TextView) findViewById(R.id.tv_chandi_context_product_details);
        putawayProductDetails = (TextView) findViewById(R.id.tv_shangjiariqi_context_product_details);
        typeProductDetails = (TextView) findViewById(R.id.tv_guige_context_product_details);
        manufactureDateProductDetails = (TextView) findViewById(R.id.tv_shengchanriqi_context_product_details);
        describedProductdetails = (TextView) findViewById(R.id.tv_miaoshu_context_product_details);
        shopShowProductDetails = (ImageView) findViewById(R.id.iv_shop_product_details);


//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SIMYOU.TTF");
//        nameProductDetails.setTypeface(typeface);

    }

    @Override
    public void initEvent() {

        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        numberPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = mProductDetailsBean.getNumberProductDetails()+1;
                mProductDetailsBean.setNumberProductDetails(num);
                mCountTv.setText(mProductDetailsBean.getNumberProductDetails()+"");
            }
        });

        numberMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mProductDetailsBean.getNumberProductDetails() > 1){
                    int num = mProductDetailsBean.getNumberProductDetails() -1;
                    mProductDetailsBean.setNumberProductDetails(num);
                    mCountTv.setText(mProductDetailsBean.getNumberProductDetails()+"");
//                    notify();
                }else {
                    Toast.makeText(ShopProductDetailsActivity.this,"不能再减少了",Toast.LENGTH_SHORT).show();
                }
            }
        });

        addShopCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 *把商品（mProductDetailsBean）的id和数量传到后台保存下来
                 * 购物车的数量或物品的改变只要下拉刷新一下就好了
                 * 把商品（mProductDetailsBean）的id和数量传到购物车页面去，通过id看是否是添加新物品，
                 * 如果已存在，就将传过去的数量与原有的数量相加
                 */
                toastMessage("添加购物车成功");
            }
        });

        shopShowProductDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopProductDetailsActivity.this,MainActivity.class);
                intent.putExtra("shop",2);
                startActivity(intent);
            }
        });

        moreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });

    }

    private void showPopupWindow() {
        View contentView = LayoutInflater.from(ShopProductDetailsActivity.this).inflate(R.layout.activity_popup, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        popupBt = (Button)contentView.findViewById(R.id.bt_popup);
        popupBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopWindow.dismiss();
            }
        });

        View rootview = LayoutInflater.from(ShopProductDetailsActivity.this).inflate(getLayoutId(), null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(ShopProductDetailsActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 2000);
    }


    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}