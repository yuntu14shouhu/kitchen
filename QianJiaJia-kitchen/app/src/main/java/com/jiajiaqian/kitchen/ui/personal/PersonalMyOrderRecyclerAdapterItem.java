package com.jiajiaqian.kitchen.ui.personal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

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
    private List<ProductBean> imgList;
    private String orderId;

    public PersonalMyOrderRecyclerAdapterItem(Context context, List<ProductBean> imgList,String orderId) {
        this.context = context;
        this.imgList = imgList;
        this.orderId = orderId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_personal_info_order_edit_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof ItemViewHolder){
//            bind((ItemViewHolder) holder,position);
//        }

        ItemViewHolder viewHolder = (ItemViewHolder) holder;//这句没意义 啊
        initView(viewHolder, position);
        initEvents(viewHolder, position);
    }

    private void initView(ItemViewHolder viewHolder, int position) {
        if (imgList != null && imgList.size() > 0) {
            if (!TextUtils.isEmpty(imgList.get(position).getProductImageUrl())) {
                Log.e("ProductImageUrl", "initView: "+imgList.get(position).getProductImageUrl() );
                Glide.with(context)
                        .load(imgList.get(position).getProductImageUrl())
                        .centerCrop()
                        .into(viewHolder.img);
            }
        }
    }

    private void initEvents(ItemViewHolder viewHolder, int position) {
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PersonalMyOrderDetailsActivity.class);
                intent.putExtra("orderId",orderId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public ItemViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.iv_order_edit_item);
        }
    }
}
