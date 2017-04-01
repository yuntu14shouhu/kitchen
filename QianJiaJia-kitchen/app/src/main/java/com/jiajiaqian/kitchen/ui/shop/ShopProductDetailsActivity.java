package com.jiajiaqian.kitchen.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductDetailsBean;
import com.jiajiaqian.kitchen.ui.MainActivity;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

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

    private ImageView topBarBack;
    private ImageView numberPlus;
    private ImageView numberMinus;
    private ProductDetailsBean mProductDetailsBean = new ProductDetailsBean();
    private Button addShopCart;
    private TextView nameProductDetails;
    private TextView smallClassProductDetails;
    private TextView priceProductDetails;
    private TextView mCountTv;
    private TextView namePinProductDetails;
    private TextView addreddProductDetails;
    private TextView putawayProductDetails;
    private TextView typeProductDetails;
    private TextView manufactureDateProductDetails;
    private TextView describedProductdetails;
    private ImageView shopShowProductDetails;

    private CustomToast toast;


    @Override
    public int getLayoutId() {
        return R.layout.activity_shoppingcart_product_details;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mProductDetailsBean = new ProductDetailsBean(
                R.drawable.ic_shoppingcart_product,"麒麟瓜","时令水果--",14.0,3,
                "麒麟瓜--","中国--","2017/3/29","1000g","这是一个傻丫头找的瓜！！！");
    }

    @Override
    public void initView() {
        topBarBack = (ImageView) findViewById(R.id.top_bar_back);
        numberPlus = (ImageView) findViewById(R.id.iv_plus_product_details);
        numberMinus = (ImageView) findViewById(R.id.iv_minus_product_details);
        addShopCart = (Button) findViewById(R.id.bt_product_details_add);
        nameProductDetails = (TextView) findViewById(R.id.tv_product_name_details);
        smallClassProductDetails = (TextView) findViewById(R.id.tv_product_small_class_name_details);
        priceProductDetails = (TextView) findViewById(R.id.tv_product_one_price_details);
        mCountTv = (TextView) findViewById(R.id.tv_number_product_details);
        namePinProductDetails = (TextView) findViewById(R.id.tv_pinming_context_product_details);
        addreddProductDetails = (TextView) findViewById(R.id.tv_chandi_context_product_details);
        putawayProductDetails = (TextView) findViewById(R.id.tv_shangjiariqi_context_product_details);
        typeProductDetails = (TextView) findViewById(R.id.tv_guige_context_product_details);
        manufactureDateProductDetails = (TextView) findViewById(R.id.tv_shengchanriqi_context_product_details);
        describedProductdetails = (TextView) findViewById(R.id.tv_miaoshu_context_product_details);
        shopShowProductDetails = (ImageView) findViewById(R.id.iv_shop_product_details);

        nameProductDetails.setText(mProductDetailsBean.getNameProductDetails());
        mCountTv.setText(mProductDetailsBean.getNumberProductDetails()+"");
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SIMYOU.TTF");
//        nameProductDetails.setTypeface(typeface);
        smallClassProductDetails.setText("时令水果--");
        priceProductDetails.setText(14.0+"");

        namePinProductDetails.setText("麒麟瓜--");
        addreddProductDetails.setText("中国--");
        putawayProductDetails.setText(getDate());
        typeProductDetails.setText("1000g");
        manufactureDateProductDetails.setText(getDate());
        describedProductdetails.setText("haaaaaaaaaaaaahaaaaaaaaa");
    }

    @Override
    public void initEvent() {

//        mProductDetailsBean = new ProductDetailsBean();

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
                 * todo
                 *把商品（mProductDetailsBean）的id和数量传到后台保存下来
                 * 购物车的数量或物品的改变只要下拉刷新一下就好了
                 * 睡觉吧
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

    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(ShopProductDetailsActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 2000);
    }


    private String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}