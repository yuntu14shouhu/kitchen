package com.jiajiaqian.kitchen.ui.sort;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.SortListBean;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/4.
 */

public class SortGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SortListBean> mDataList;
    private int mResId;
    private Context mContext;

    public SortGridAdapter(List<SortListBean> mList, int resId, Context context) {
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

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private void initView(DataListVH dataListVH, int position){
        if (mDataList != null && mDataList.size() > 0) {
            if (!TextUtils.isEmpty(mDataList.get(position).getSortName())) {
                dataListVH.mSortName.setText(mDataList.get(position).getSortName());
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getSortImageUrl())){
                Glide.with(mContext)
                        .load(mDataList.get(position).getSortImageUrl())
                        .centerCrop()
                        .into(dataListVH.mSortImage);
            }
        }
    }

    private void initEvents(DataListVH dataListVH, final int position) {
        dataListVH.mSortLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext,SubSortListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("sort_list_data",mDataList.get(position).getSortList());
                intent.putExtra("sort_list",bundle);
                intent.putExtra("sort_name",mDataList.get(position).getSortName());
                mContext.startActivity(intent);
            }
        });
    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private RelativeLayout mSortLayout;
        private ImageView mSortImage;
        private TextView mSortName;

        DataListVH(View itemView) {
            super(itemView);
            mSortLayout = (RelativeLayout) itemView.findViewById(R.id.rl_sort);
            mSortImage = (ImageView) itemView.findViewById(R.id.sort_image);
            mSortName = (TextView) itemView.findViewById(R.id.sort_name);

        }
    }
}
