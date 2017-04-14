package com.jiajiaqian.kitchen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.FuzzyListBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

import org.json.JSONObject;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 搜索结果列表
 * @Date 2017-04-13 15:27
 * @email qianjiajia_2013@126.com
 */
public class ProductSearchResultActivity extends BaseActivity{

    private RecyclerView resultRecyclerView;
    private TextView topBackBar;
    private TextView topTitleBar;
    private String searchName;

    private CustomToast toast;

    @Override
    public int getLayoutId() {
        return R.layout.activity_product_search_list;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        searchName = intent.getStringExtra("searchName");
        //进行模糊查询
        KitchenHttpManager.getInstance().getFuzzy(searchName, new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-fuzzy--", volleyError.getMessage() + "");
            }
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-fuzzy--", jsonObject + "");
                if (jsonObject != null) {
                    FuzzyListBean fuzzyListBean = GsonUtils.jsonToBean(jsonObject.toString(), FuzzyListBean.class);
                    if (fuzzyListBean.getData() != null) {
                        getFuzzyData(fuzzyListBean.getData());
                        toastMessage("查询成功！");
                    }
                }
            }
        });
    }

    private void getFuzzyData(List<FuzzyListBean.DataBean> data) {
        ProductSearchResultListAdapter adapter = new ProductSearchResultListAdapter(ProductSearchResultActivity.this,R.layout.activity_product_search_list_item,data);
        resultRecyclerView.setAdapter(adapter);
    }

    @Override
    public void initView() {
        resultRecyclerView = (RecyclerView) findViewById(R.id.rl_search_result_list);
        topBackBar = (TextView) findViewById(R.id.top_bar_back);
        topTitleBar = (TextView) findViewById(R.id.top_bar_title);
        topTitleBar.setText("搜索结果");
        resultRecyclerView.setLayoutManager(new GridLayoutManager(resultRecyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false));
    }

    @Override
    public void initEvent() {
        topBackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductSearchResultActivity.this,ProductSearchActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(ProductSearchResultActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }
}