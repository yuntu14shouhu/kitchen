package com.jiajiaqian.kitchen.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class GroupBuyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProductBean> mDataList;
    private int mResId;
    private Context mContext;

    public GroupBuyListAdapter(List<ProductBean> mList, int resId, Context context) {
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

            dataListVH.mPrice.setText("¥" + mDataList.get(position).getPrice() + "");
            dataListVH.mDiscountPrice.setText("¥" + mDataList.get(position).getGroupBuyPrice() + "");

            if (!TextUtils.isEmpty(mDataList.get(position).getProductImageUrl())) {
                Glide.with(mContext)
                        .load(mDataList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(dataListVH.mProductImage);
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductName())) {
                dataListVH.mProductName.setText(mDataList.get(position).getProductName());
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getDescribed())) {
                dataListVH.mProductDescribe.setText(mDataList.get(position).getDescribed());
            }

            dataListVH.mGroupNum.setText(" " + mDataList.get(position).getGroupBuyPersonNumber() + "人团");

        }
    }

    private void initEvents(DataListVH dataListVH, int position) {
        dataListVH.mGroupGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private TextView mIsBaoYou, mProductName, mProductDescribe, mPrice, mDiscountPrice, mGroupNum;
        private ImageView mProductImage;
        private Button mGroupGoBtn;

        DataListVH(View itemView) {
            super(itemView);
            mIsBaoYou = (TextView) itemView.findViewById(R.id.is_baoYou);
            mProductImage = (ImageView) itemView.findViewById(R.id.pro_image);
            mProductName = (TextView) itemView.findViewById(R.id.tv_pro_name);
            mProductDescribe = (TextView) itemView.findViewById(R.id.tv_product_describe);
            mPrice = (TextView) itemView.findViewById(R.id.price);
            mDiscountPrice = (TextView) itemView.findViewById(R.id.tv_discount_price);
            mGroupNum = (TextView) itemView.findViewById(R.id.tv_group_num);
            mGroupGoBtn = (Button) itemView.findViewById(R.id.imgBtn_go_group);

        }
    }
}
