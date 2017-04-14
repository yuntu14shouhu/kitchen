package com.jiajiaqian.kitchen.ui.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
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
 * @Description 下单adapter
 * @Date 2017-04-01 10:56
 * @email qianjiajia_2013@126.com
 */
public class ShopAccountActivityAdapter extends RecyclerView.Adapter<ShopAccountActivityAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<MyOrderDetailsBean.ProductBean> productList;
    private int srcId;

    public ShopAccountActivityAdapter(Context context, int srcId, List<MyOrderDetailsBean.ProductBean> productList) {
        this.context = context;
        this.productList = productList;
        this.srcId = srcId;
        mInflater = LayoutInflater.from(context);
        Log.e("results", "PersonalMyOrderDetailsAdapter: "+productList.toString());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(srcId,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (productList != null && productList.size() > 0) {
            if (!TextUtils.isEmpty(productList.get(position).getProductImageUrl())) {
                Log.e("ProductImageUrl", "initView: "+productList.get(position).getProductImageUrl() );
                Glide.with(context)
                        .load(productList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(holder.productImgDetails);
            }
            if(!TextUtils.isEmpty(productList.get(position).getProductName())){
                holder.productNameDetails.setText(productList.get(position).getProductName());
            }
            if(!TextUtils.isEmpty(productList.get(position).getPrice()+"")){
                holder.productPriceDetails.setText(productList.get(position).getPrice()+"");
            }
            if(!TextUtils.isEmpty(productList.get(position).getLimitNumber() +"")){
                holder.productNumberDetails.setText(productList.get(position).getLimitNumber()+"");
            }

        }
    }

    @Override
    public int getItemCount() {
        return productList == null ? 0:productList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

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