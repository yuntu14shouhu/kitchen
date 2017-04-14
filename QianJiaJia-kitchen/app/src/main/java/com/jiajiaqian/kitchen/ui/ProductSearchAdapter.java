package com.jiajiaqian.kitchen.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.SearchContentBean;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 商品搜索类适配器
 * @Date 2017-04-11 17:38
 * @email qianjiajia_2013@126.com
 */
public class ProductSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SearchContentBean.DataBean> mDataList;
    private int mResId;
    private Context mContext;

    public ProductSearchAdapter(List<SearchContentBean.DataBean> mList, int resId, Context context) {
        this.mDataList = mList;
        this.mResId = resId;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mResId, parent, false);
        return new DataListVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataListVH viewHolder = (DataListVH) holder;
        initView(viewHolder, position);
        initEvents(viewHolder, position);
    }

    private void initView(DataListVH dataListVH, int position) {
        if (mDataList != null && mDataList.size() > 0) {
            if (!TextUtils.isEmpty(mDataList.get(position).getSearchContent())) {
                dataListVH.searchContentTv.setText(mDataList.get(position).getSearchContent());
            }
        }
    }

    private void initEvents(DataListVH dataListVH, final int position) {
        dataListVH.searchContentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ProductSearchResultActivity.class);
                intent.putExtra("searchName",mDataList.get(position).getSearchContent());
                mContext.startActivity(intent);
                Toast.makeText(mContext,"查询成功!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private TextView searchContentTv;

        DataListVH(View itemView) {
            super(itemView);
            searchContentTv = (TextView) itemView.findViewById(R.id.tv_search_content);
        }
    }
}
