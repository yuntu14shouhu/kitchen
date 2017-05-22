package com.jiajiaqian.kitchen.ui.personal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.MyOrderDetailsBean;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单详情适配器
 * @Date 2017-03-27 18:20
 * @email qianjiajia_2013@126.com
 */
public class PersonalMyOrderDetailsAdapter extends RecyclerView.Adapter<PersonalMyOrderDetailsAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<MyOrderDetailsBean.ProductBean> mDataList;
    private int srcId;
    
    public PersonalMyOrderDetailsAdapter(Context context, int srcId, List<MyOrderDetailsBean.ProductBean> mDataList) {
        this.mContext = context;
        this.mDataList = mDataList;
        this.srcId = srcId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(srcId, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (mDataList != null && mDataList.size() > 0) {
            if (!TextUtils.isEmpty(mDataList.get(position).getImageUrl())) {
                Glide.with(mContext)
                        .load(mDataList.get(position).getImageUrl())
                        .centerCrop()
                        .into(holder.productImgDetails);
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductName())) {
                holder.productNameDetails.setText(mDataList.get(position).getProductName());
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getPrice()+"")) {
                holder.productPriceDetails.setText(mDataList.get(position).getPrice()+"");
            }
            if (!TextUtils.isEmpty(mDataList.get(position).getProductNumber()+"")) {
                holder.productNumberDetails.setText(mDataList.get(position).getProductNumber()+"");
            }

        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImgDetails;
        private TextView productNameDetails;
        private TextView productPriceDetails;
        private TextView productNumberDetails;

        public MyViewHolder(View itemView) {
            super(itemView);
            productImgDetails = (ImageView) itemView.findViewById(R.id.iv_order_details_info);
            productNameDetails = (TextView) itemView.findViewById(R.id.tv_order_details_product_name);
            productPriceDetails = (TextView) itemView.findViewById(R.id.tv_order_details_product_price);
            productNumberDetails = (TextView) itemView.findViewById(R.id.tv_order_details_product_number);
        }
    }
}