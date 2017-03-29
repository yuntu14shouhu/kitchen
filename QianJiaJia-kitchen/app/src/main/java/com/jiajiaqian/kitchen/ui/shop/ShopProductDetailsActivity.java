package com.jiajiaqian.kitchen.ui.shop;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 商品详情查看
 * @Date 2017-03-23 23:14
 * @email qianjiajia_2013@126.com
 */
public class ShopProductDetailsActivity extends BaseActivity {

    private ImageView topBarBack;
    private ImageView numberPlus;
    private ImageView numberMinus;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shoppingcart_product_details;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack = (ImageView) findViewById(R.id.top_bar_back);
        numberPlus = (ImageView) findViewById(R.id.iv_plus_product_details);
        numberMinus = (ImageView) findViewById(R.id.iv_minus_product_details);
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
//                int num = results.get(position).getProductNumber()+1;
//                results.get(position).setProductNumber(num);
//                notifyDataSetChanged();
            }
        });
    }
}