package com.jiajiaqian.kitchen.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.FuzzyListBean;
import com.jiajiaqian.kitchen.ui.shop.ShopProductDetailsActivity;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 搜索结果list
 * @Date 2017-04-13 15:08
 * @email qianjiajia_2013@126.com
 */
public class ProductSearchResultListAdapter extends RecyclerView.Adapter<ProductSearchResultListAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<FuzzyListBean.DataBean> mDataBeanList;
    private int srcId;

    public ProductSearchResultListAdapter(Context context, int srcId, List<FuzzyListBean.DataBean> mDataBeanList) {
        this.context = context;
        this.mDataBeanList = mDataBeanList;
        this.srcId = srcId;
        mInflater = LayoutInflater.from(context);
        Log.e("results", "ProductSearchResultListAdapter: " + mDataBeanList.toString());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(srcId, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if(mDataBeanList != null && mDataBeanList.size() > 0){
            if (!TextUtils.isEmpty(mDataBeanList.get(position).getProductImageUrl())) {
                Log.e("ProductImageUrl", "initView: "+mDataBeanList.get(position).getProductImageUrl() );
                Glide.with(context)
                        .load(mDataBeanList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(holder.imgShowTv);
            }
            if (!TextUtils.isEmpty(mDataBeanList.get(position).getProductName())) {
                holder.nameShowTv.setText(mDataBeanList.get(position).getProductName());
            }
            if (mDataBeanList.get(position).getPrice() != 0) {
                holder.priceShowTv.setText(mDataBeanList.get(position).getPrice() + "");
            }
        }
        holder.imgShowTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShopProductDetailsActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataBeanList == null ? 0 : mDataBeanList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgShowTv;
        private TextView nameShowTv;
        private TextView priceShowTv;
        private ImageButton addShowImB;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgShowTv = (ImageView) itemView.findViewById(R.id.iv_show_product);
            nameShowTv = (TextView) itemView.findViewById(R.id.tv_show_name);
            priceShowTv = (TextView) itemView.findViewById(R.id.tv_show_price);
            addShowImB = (ImageButton) itemView.findViewById(R.id.imgBtn_show_add);
        }
    }
}