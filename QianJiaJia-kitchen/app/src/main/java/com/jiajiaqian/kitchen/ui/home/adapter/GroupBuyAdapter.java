package com.jiajiaqian.kitchen.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

import java.util.List;

/**
 * Created by jasonxu on 2017/4/5.
 */

public class GroupBuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProductBean> mDataList;
    private int mResId;
    private Context mContext;

    public GroupBuyAdapter(List<ProductBean> mList, int resId, Context context) {
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
            if (!TextUtils.isEmpty(mDataList.get(position).getProductName())) {
                dataListVH.mProNameTv.setText(mDataList.get(position).getProductName());
            }
            if (mDataList.get(position).getIsGroupBuy() == 1 && mDataList.get(position).getGroupBuyPersonNumber() != 0) {
                dataListVH.mProNum.setText(mDataList.get(position).getGroupBuyPersonNumber() + "人团" + "");
            }
            //是否包邮没有字段，暂时不考虑，团购的一律包邮
            if (mDataList.get(position).getGroupBuyPrice() != 0) {
                dataListVH.mPrice.setText("¥"+ String.valueOf(mDataList.get(position).getGroupBuyPrice()));
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductImageUrl())){
                Glide.with(mContext)
                        .load(mDataList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(dataListVH.mProductImage);
            }
        }
    }

    private void initEvents(DataListVH dataListVH, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private LinearLayout mGroupBuyLayout;
        private TextView mProNameTv, mProNum, mPrice, mIsBaoYou;
        private ImageView mProductImage;

        DataListVH(View itemView) {
            super(itemView);
            mProNameTv = (TextView) itemView.findViewById(R.id.pro_name);
            mProNum = (TextView) itemView.findViewById(R.id.pro_num);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mIsBaoYou = (TextView) itemView.findViewById(R.id.is_baoYou);
            mProductImage = (ImageView) itemView.findViewById(R.id.pro_image);
            mGroupBuyLayout = (LinearLayout) itemView.findViewById(R.id.ll_group_buy);
        }
    }
}
