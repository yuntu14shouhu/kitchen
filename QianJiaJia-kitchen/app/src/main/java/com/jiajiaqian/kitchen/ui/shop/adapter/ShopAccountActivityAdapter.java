package com.jiajiaqian.kitchen.ui.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderDetailsBean;
import com.jiajiaqian.kitchen.ui.shop.ShopProductDetailsActivity;

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
    private List<OrderDetailsBean> results;
    private int srcId;

    public List<OrderDetailsBean> getResults() {
        return results;
    }


    public ShopAccountActivityAdapter(Context context, int srcId, List<OrderDetailsBean> results) {
        this.context = context;
        this.results = results;
        this.srcId = srcId;
        mInflater = LayoutInflater.from(context);
        Log.e("results", "PersonalMyOrderDetailsAdapter: "+results.toString());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(srcId,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.productImgDetails.setImageResource(results.get(position).getProductImgDetails());
        holder.productImgDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ShopProductDetailsActivity.class));
            }
        });
        holder.productNameDetails.setText(results.get(position).getProductNameDetails());
        holder.productPriceDetails.setText(results.get(position).getProductPriceDetails()+"");
        holder.productNumberDetails.setText(results.get(position).getProductNumberDetails()+"");
//        holder.productDefaultsDetails.setText(results.get(position).getProductDefaultDetails());
    }

    @Override
    public int getItemCount() {
        return results == null ? 0:results.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImgDetails;
        private TextView productNameDetails;
        private TextView productPriceDetails;
        private TextView productNumberDetails;
        //        private TextView productDefaultsDetails;
        public MyViewHolder(View itemView) {
            super(itemView);
            productImgDetails = (ImageView) itemView.findViewById(R.id.iv_order_details_info);
            productNameDetails = (TextView) itemView.findViewById(R.id.tv_order_details_product_name);
            productPriceDetails = (TextView) itemView.findViewById(R.id.tv_order_details_product_price);
            productNumberDetails = (TextView) itemView.findViewById(R.id.tv_order_details_product_number);
//            productDefaultsDetails = (TextView) itemView.findViewById(R.id.tv_order_defaults_details_product);
        }
    }
}