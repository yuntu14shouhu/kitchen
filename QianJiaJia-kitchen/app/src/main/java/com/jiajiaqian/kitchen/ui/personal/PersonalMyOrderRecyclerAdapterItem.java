package com.jiajiaqian.kitchen.ui.personal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderProductImgBean;
import com.jiajiaqian.kitchen.ui.personal.adapter.CustomBitmapLoadCallBack;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 嵌套RecyclerView的Adapter
 * @Date 2017-03-22 11:36
 * @email qianjiajia_2013@126.com
 */
public class PersonalMyOrderRecyclerAdapterItem extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<OrderProductImgBean> results;


    //get & set
    public List<OrderProductImgBean> getResults() {
        return results;
    }

    public PersonalMyOrderRecyclerAdapterItem(Context context, List<OrderProductImgBean> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_personal_info_order_edit_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder){
            bind((ItemViewHolder) holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    /////////////////////////////

    private void bind(ItemViewHolder holder, int position){
        x.image().bind(holder.item_recyc_type2_item_img,
                results.get(position).getProductImg(),
                new ImageOptions.Builder().build(),
                new CustomBitmapLoadCallBack(holder.item_recyc_type2_item_img));
        holder.item_recyc_type2_item_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,PersonalMyOrderDetailsActivity.class));
            }
        });
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView item_recyc_type2_item_img;

        public ItemViewHolder(View itemView) {
            super(itemView);
            item_recyc_type2_item_img = (ImageView) itemView.findViewById(R.id.iv_order_edit_item);
        }
    }
}
