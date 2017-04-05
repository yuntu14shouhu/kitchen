package com.jiajiaqian.kitchen.ui.shop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderDetailsBean;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.personal.PersonalMyOrderDetailsActivity;
import com.jiajiaqian.kitchen.ui.personal.PersonalMyOrderDetailsAdapter;
import com.jiajiaqian.kitchen.utils.CustomToast;
import com.jiajiaqian.kitchen.utils.MyCommonDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 购物车结算
 * @Date 2017-03-23 13:30
 * @email qianjiajia_2013@126.com
 */
public class ShopAccountsActivity extends BaseActivity {

    private TextView topBarBack;
    private TextView topBarTitle;
    private List<OrderDetailsBean> mOrderDetailsBeanList;
    private RecyclerView mRecyclerView;
    private PersonalMyOrderDetailsAdapter mAdapter;
    private ImageView iv_pay_address;
    private Button btCancle;
    private Button btPay;

    private CustomToast toast;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shoppingcart_acctounts;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mOrderDetailsBeanList = new ArrayList<>();
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶三叶草三叶草三叶草三叶草三叶草三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
    }

    @Override
    public void initView() {
        mOrderDetailsBeanList = new ArrayList<>();
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶三叶草三叶草三叶草三叶草三叶草三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));
        mOrderDetailsBeanList.add(new OrderDetailsBean(R.drawable.ic_logo,"三叶草三叶草",12.03,3,"300g"));

        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBarTitle = (TextView) findViewById(R.id.top_bar_title);
        topBarTitle.setText("填写订单");
        iv_pay_address = (ImageView) findViewById(R.id.iv_pay_details);
        btCancle = (Button) findViewById(R.id.bt_pay_cancel_order);
        btPay = (Button) findViewById(R.id.bt_go_pay);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_pay_details);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter = new PersonalMyOrderDetailsAdapter(ShopAccountsActivity.this, R.layout.activity_personal_info_order_details_item, mOrderDetailsBeanList));
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        iv_pay_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopAccountsActivity.this,ShoppingCartPayAddressChoose.class);
                startActivity(intent);
            }
        });

        btCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog();
            }
        });

        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage("支付功能尚未开通");
            }
        });
    }

    private void myDialog() {
        new MyCommonDialog(this,"您正在取消订单..." ,"Kitchen发货","确定","取消")
                .setOnDiaLogListener(new MyCommonDialog.OnDialogListener() {
                    @Override
                    public void dialogListener(String btnType, View customView, DialogInterface dialogInterface, int which) {
                        switch (btnType){
                            case "positive":
                                toastMessage("订单正在被取消...");
                                Intent intent = new Intent(ShopAccountsActivity.this, PersonalMyOrderDetailsActivity.class);
                                startActivity(intent);
                                break;
                            case "negative":
                                break;
                        }
                    }
                }).showDialog();
    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(ShopAccountsActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }
}