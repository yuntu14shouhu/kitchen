package com.jiajiaqian.kitchen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.SearchContentBean;
import com.jiajiaqian.kitchen.common.network.KitchenHttpManager;
import com.jiajiaqian.kitchen.common.network.OkJsonRequest;
import com.jiajiaqian.kitchen.common.utils.GsonUtils;
import com.jiajiaqian.kitchen.common.utils.UserInfoUtils;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.CustomToast;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by jasonxu on 2017/2/26.
 */

public class ProductSearchActivity extends BaseActivity {

    private ImageButton mBackBtn;
    private TextView mSearchBtn, mHistoryTv;
    private Button mClearBtn;
    private EditText mWord;
    private RecyclerView mHotListView, mHistoryListView;
    private ImageButton backBtn;

    private CustomToast toast;

    @Override
    public int getLayoutId() {
        return R.layout.activity_product_search;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        //用户未登陆，只能显示热门搜索
        if (UserInfoUtils.getUserId(this) == null) {
            mHistoryTv.setVisibility(View.GONE);
            mHistoryListView.setVisibility(View.GONE);
            mClearBtn.setVisibility(View.GONE);
        } else {
            mHistoryTv.setVisibility(View.VISIBLE);
            mHistoryListView.setVisibility(View.VISIBLE);
            mClearBtn.setVisibility(View.VISIBLE);
        }

        KitchenHttpManager.getInstance().getHistorySearchList("userId","",new OkJsonRequest.OKResponseCallback(){

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-history--", jsonObject + "");
                if (jsonObject != null) {
                    SearchContentBean searchContentData = GsonUtils.jsonToBean(jsonObject.toString(), SearchContentBean.class);
                    getHistoryData(searchContentData.getData());
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-history--", volleyError.getMessage() + "");
            }
        });

        KitchenHttpManager.getInstance().getHotSearchList("", new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error-hot--", volleyError.getMessage() + "");
            }
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success-hot--", jsonObject + "");
                if (jsonObject != null) {
                    SearchContentBean searchContentBean = GsonUtils.jsonToBean(jsonObject.toString(), SearchContentBean.class);
                    if (searchContentBean.getData() != null) {
                        getSearchHotData(searchContentBean.getData());
                    }
                }
            }
        });
    }

    private void getHistoryData(List<SearchContentBean.DataBean> data) {
        ProductSearchAdapter adapter = new ProductSearchAdapter(data,R.layout.activity_product_search_item,ProductSearchActivity.this);
        mHistoryListView.setAdapter(adapter);
    }

    private void getSearchHotData(List<SearchContentBean.DataBean> data) {
        ProductSearchAdapter adapter = new ProductSearchAdapter(data,R.layout.activity_product_search_item,ProductSearchActivity.this);
        mHotListView.setAdapter(adapter);
    }


    @Override
    public void initView() {
        mBackBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mSearchBtn = (TextView) this.findViewById(R.id.tv_search);
        mHistoryTv = (TextView) this.findViewById(R.id.tv_history);
        mClearBtn = (Button) this.findViewById(R.id.btn_clear_history);
        mWord = (EditText) this.findViewById(R.id.et_word);
        mHistoryListView = (RecyclerView) this.findViewById(R.id.rcy_history_search);
        mHotListView = (RecyclerView) this.findViewById(R.id.rcy_hot_search);
        backBtn = (ImageButton) this.findViewById(R.id.imgBtn_back);
        mHotListView.setHasFixedSize(true);
        mHotListView.setItemAnimator(new DefaultItemAnimator());
        mHotListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mHistoryListView.setHasFixedSize(true);
        mHistoryListView.setItemAnimator(new DefaultItemAnimator());
        mHistoryListView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initEvent() {

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (saveSearchContent() != null){
                    //保存搜索内容
                    postSearchContent(saveSearchContent());
                    Intent intent = new Intent(ProductSearchActivity.this,ProductSearchResultActivity.class);
                    //从输入框中获取到模糊查询的关键字
                    String[] data = saveSearchContent().toString().split("\"");

                    intent.putExtra("searchName", data[3]);
                    startActivity(intent);

                    Log.e("hhhhhh",data[3]+"");
                }
            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KitchenHttpManager.getInstance().getDeleteAllSearchList("userId","",new OkJsonRequest.OKResponseCallback(){

                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.e("success-delete--", jsonObject + "");
                        toastMessage("历史搜索内容已全部清除!");
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("error-delete--", volleyError.getMessage() + "");
                    }
                });
            }
        });

    }

    private void postSearchContent(JSONObject jsonObject) {
        KitchenHttpManager.getInstance().saveSearchContent("", jsonObject, new OkJsonRequest.OKResponseCallback() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("error", volleyError.getMessage() + "");
            }

            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("success", jsonObject + "");
            }
        });
    }

    private JSONObject saveSearchContent() {
        JSONObject jsonObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(mWord.getText() + "")) {
                jsonObject.put("searchContent", mWord.getText());
            } else {
                Toast.makeText(this, "搜索内容不能为空", Toast.LENGTH_SHORT).show();
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void toastMessage(String content) {
        if (toast != null) {
            toast.hide();
        }
        toast = new CustomToast(ProductSearchActivity.this,
                (ViewGroup) this.findViewById(R.id.toast_custom_parent));
        toast.show(content, 5000);
    }

}
