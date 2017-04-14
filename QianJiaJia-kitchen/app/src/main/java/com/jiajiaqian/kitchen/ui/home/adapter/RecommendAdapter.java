package com.jiajiaqian.kitchen.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/5.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ProductBean> mDataList;
    private int mResId;
    private Context mContext;

    public RecommendAdapter(List<ProductBean> mList, int resId, Context context) {
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

    private void initView(DataListVH dataListVH, int position) {

        if (mDataList != null && mDataList.size() > 0) {
            if (mDataList.get(position).getIsDiscount() == 1) { //是打折优惠商品
                dataListVH.mDashLine.setVisibility(View.VISIBLE);
                dataListVH.mIsYouHui.setVisibility(View.VISIBLE);
                dataListVH.mPrice.setVisibility(View.VISIBLE);
                dataListVH.mPrice.setText("¥" + mDataList.get(position).getPrice() + "");
                dataListVH.mDiscountPrice.setText("¥" + mDataList.get(position).getDiscountPrice() + "");
            } else {
                dataListVH.mPrice.setVisibility(View.GONE);
                dataListVH.mDashLine.setVisibility(View.GONE);
                dataListVH.mIsYouHui.setVisibility(View.GONE);
                dataListVH.mDiscountPrice.setText("¥" + mDataList.get(position).getPrice() + "");
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductImageUrl())) {
                Glide.with(mContext)
                        .load(mDataList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(dataListVH.mProductImage);
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductName())) {
                dataListVH.mProductName.setText(mDataList.get(position).getProductName());
            }

        }
    }

    private void initEvents(DataListVH dataListVH, int position) {

    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private TextView mIsYouHui;
        private ImageView mProductImage;
        private TextView mProductName;
        private TextView mDashLine;
        private TextView mPrice;
        private TextView mDiscountPrice;
        private ImageButton mShopAdd;

        DataListVH(View itemView) {
            super(itemView);
            mIsYouHui = (TextView) itemView.findViewById(R.id.is_you_hui);
            mProductImage = (ImageView) itemView.findViewById(R.id.pro_image);
            mProductName = (TextView) itemView.findViewById(R.id.pro_name);
            mDashLine = (TextView) itemView.findViewById(R.id.tv_line);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mDiscountPrice = (TextView) itemView.findViewById(R.id.discount_price);
            mShopAdd = (ImageButton) itemView.findViewById(R.id.pro_add_btn);

        }
    }
}
