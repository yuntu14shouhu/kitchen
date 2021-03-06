package com.jiajiaqian.kitchen.ui.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.ShopBeanN;
import com.jiajiaqian.kitchen.ui.shop.ShopProductDetailsActivity;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 商品RecyclerAdapter适配器
 * @Date 2017-03-23 16:28
 * @email qianjiajia_2013@126.com
 */
public class ShopFragmentRecycleAdapter extends RecyclerView.Adapter<ShopFragmentRecycleAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater mInflater;
    private List<ShopBeanN.DataBean> results;
    private int srcId;

    public List<ShopBeanN.DataBean> getResults() {
        return results;
    }
    //将adapter的方法回调给View层
    public interface ShopAdapterCall{
        void dealNumChanged(List<ShopBeanN.DataBean> results);
    }
    public ShopAdapterCall mShopAdapterCall;
    public void setShopAdapterCall(ShopAdapterCall mShopAdapterCall){
        this.mShopAdapterCall = mShopAdapterCall;
    }

    //刷新数据源
    public void upData(List<ShopBeanN.DataBean> results){
        if (this.results!=null) {
            results.clear();
            this.results.addAll(results);
            notifyDataSetChanged();
        }
    }

    public ShopFragmentRecycleAdapter(Context context, int srcId, List<ShopBeanN.DataBean> results) {
        this.context = context;
        this.results = results;
        this.srcId = srcId;
        mInflater = LayoutInflater.from(context);
//        Log.e("results", "ShopFragmentRecycleAdapter: "+results.toString());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(srcId,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if(results != null && results.size() > 0){
            if (!TextUtils.isEmpty(results.get(position).getImageUrl())) {
                Glide.with(context)
                        .load(results.get(position).getImageUrl())
                        .centerCrop()
                        .into(holder.productImage);
            }
            holder.productImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ShopProductDetailsActivity.class);
                    intent.putExtra("productId",results.get(position).getProductId());
                    context.startActivity(intent);
                }
            });
            if (!TextUtils.isEmpty(results.get(position).getProductName())) {
                holder.productName.setText(results.get(position).getProductName());
            }
            if (!TextUtils.isEmpty(results.get(position).getProductNumber()+"")) {
                holder.productNumber.setText(results.get(position).getProductNumber()+"");
            }
            if (!TextUtils.isEmpty(results.get(position).getPrice()+"")) {
                holder.productPrice.setText(results.get(position).getPrice()+"");
            }
        }

        holder.productMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(results.get(position).getProductNumber() > 1){
                    int num = results.get(position).getProductNumber()-1;
                    results.get(position).setProductNumber(num);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(context,"不能再减少了",Toast.LENGTH_SHORT).show();
                }
                mShopAdapterCall.dealNumChanged(results);
            }
        });
        holder.productPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = results.get(position).getProductNumber()+1;
                results.get(position).setProductNumber(num);
                notifyDataSetChanged();
                mShopAdapterCall.dealNumChanged(results);
            }
        });
        holder.productDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.remove(holder.getLayoutPosition());
                notifyItemRemoved(holder.getLayoutPosition());
                mShopAdapterCall.dealNumChanged(results);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results == null ? 0:results.size();
    }



//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.iv_minus_shop:
//                productMinus(mProductNumber);
//                break;
//            case R.id.iv_plus_shop:
//                productPlus(mProductNumber);
//                break;
////            case R.id.iv_delete_shop:
////                int pos =
////                productDelete(mProductNumber);
////                break;
//            default:
//                break;
//        }
//    }
//
//
//    private void productPlus(int productNumber) {
//        ++productNumber;
//    }
//
//    private void productMinus(int productNumber) {
//    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productName;
        private ImageView productMinus;
        private TextView productNumber;
        private ImageView productPlus;
        private TextView productPrice;
        private ImageView productDelete;
        public MyViewHolder(View itemView) {
            super(itemView);
            productImage = (ImageView) itemView.findViewById(R.id.iv_product_shop);
            productName = (TextView) itemView.findViewById(R.id.tv_product_name_shop);
            productMinus = (ImageView) itemView.findViewById(R.id.iv_minus_shop);
            productNumber = (TextView) itemView.findViewById(R.id.tv_number_shop);
            productPlus = (ImageView) itemView.findViewById(R.id.iv_plus_shop);
            productPrice = (TextView) itemView.findViewById(R.id.tv_price_shop);
            productDelete = (ImageView) itemView.findViewById(R.id.iv_delete_shop);
        }
    }
}