package com.jiajiaqian.kitchen.ui.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 选择收货地址适配器
 * @Date 2017-04-01 14:54
 * @email qianjiajia_2013@126.com
 */
public class ShoppingCartPayAddressChooseAdapter extends RecyclerView.Adapter<ShoppingCartPayAddressChooseAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater mInflater;
    private List<AddressBean> results;
    private int srcId;

    public List<AddressBean> getResults() {
        return results;
    }

    public ShoppingCartPayAddressChooseAdapter(Context context, int srcId, List<AddressBean> results) {
        this.context = context;
        this.results = results;
        this.srcId = srcId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(srcId,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tvName.setText(results.get(position).getConsigneeName());
        holder.tvPhone.setText(results.get(position).getConsigneePhone());
        holder.tvAddress.setText(results.get(position).getConsigneeAddress());
        holder.tvAddressType.setText(results.get(position).getAddressType()+"");

    }

    @Override
    public int getItemCount() {
        return results == null ? 0:results.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvPhone;
        private TextView tvAddress;
        private TextView tvAddressType;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_choose_address_name);
            tvPhone = (TextView) itemView.findViewById(R.id.tv_choose_address_phone);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_choose_address_address);
            tvAddressType = (TextView) itemView.findViewById(R.id.tv_choose_address_type);
        }
    }
}