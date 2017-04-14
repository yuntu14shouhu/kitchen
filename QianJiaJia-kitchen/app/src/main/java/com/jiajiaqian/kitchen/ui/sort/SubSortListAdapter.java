package com.jiajiaqian.kitchen.ui.sort;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.ui.shop.ShopProductDetailsActivity;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/4.
 */

public class SubSortListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProductBean> mDataList;
    private int mResId;
    private Context mContext;
    private SortListCallback mSortListCallback;

    public SubSortListAdapter(List<ProductBean> mList, int resId, Context context,SortListCallback callback) {
        this.mDataList = mList;
        this.mResId = resId;
        this.mContext = context;
        mSortListCallback = callback;
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
            if (!TextUtils.isEmpty(mDataList.get(position).getProductImageUrl())) {
                Glide.with(mContext)
                        .load(mDataList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(dataListVH.mProImage);
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductName())) {
                dataListVH.mProName.setText(mDataList.get(position).getProductName());
            }
            if (mDataList.get(position).getIsDiscount() == 1) { //是打折优惠商品
                dataListVH.mPriceLayout.setVisibility(View.VISIBLE);
                dataListVH.mIsYouHui.setVisibility(View.VISIBLE);
                dataListVH.mXieLine.setVisibility(View.VISIBLE);
                dataListVH.mDiscountPrice.setText("¥" + mDataList.get(position).getDiscountPrice() + "");
                dataListVH.mPrice.setText("¥" + mDataList.get(position).getPrice() + "");
            } else {
                dataListVH.mPriceLayout.setVisibility(View.GONE);
                dataListVH.mIsYouHui.setVisibility(View.GONE);
                dataListVH.mXieLine.setVisibility(View.GONE);
                dataListVH.mDiscountPrice.setText("¥" + mDataList.get(position).getPrice() + "");
            }
        }

    }

    private void initEvents(DataListVH dataListVH, final int position) {

        dataListVH.mProLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSortListCallback.sortListItemClick(mDataList.get(position));
            }
        });

        dataListVH.mShopAddImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSortListCallback.shopAddClick(mDataList.get(position));
            }
        });

        dataListVH.mProImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ShopProductDetailsActivity.class);
                intent.putExtra("productId",mDataList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private RelativeLayout mPriceLayout;
        private LinearLayout mProLayout;
        private ImageView mProImage;
        private ImageButton mShopAddImgBtn;
        private TextView mProName, mIsYouHui, mDiscountPrice, mPrice, mXieLine;

        DataListVH(View itemView) {
            super(itemView);
            mProLayout = (LinearLayout) itemView.findViewById(R.id.ll_pro_details);
            mPriceLayout = (RelativeLayout) itemView.findViewById(R.id.rl_price);
            mProImage = (ImageView) itemView.findViewById(R.id.pro_image);
            mShopAddImgBtn = (ImageButton) itemView.findViewById(R.id.imgBtn_shop_add);
            mProName = (TextView) itemView.findViewById(R.id.tv_pro_name);
            mIsYouHui = (TextView) itemView.findViewById(R.id.is_you_hui);
            mDiscountPrice = (TextView) itemView.findViewById(R.id.tv_discount_price);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mXieLine = (TextView) itemView.findViewById(R.id.tv_xie_line);

        }
    }

    public interface SortListCallback {
        void shopAddClick(ProductBean productBean);
        void sortListItemClick(ProductBean productBean);
    }
}
