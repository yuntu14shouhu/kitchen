package com.jiajiaqian.kitchen.ui.personal;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderBean;
import com.jiajiaqian.kitchen.common.entity.OrderProductImgBean;
import com.jiajiaqian.kitchen.ui.personal.adapter.FullyGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单Adapter
 * @Date 2017-03-22 9:56
 * @email qianjiajia_2013@126.com
 */
public class PersonalMyOrderRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<OrderBean> results;


    //get & set
    public List<OrderBean> getResults() {
        return results;
    }

    //type
    public static final int TYPE_1 = 0xff01;
//    public static final int TYPE_2 = 0xff02;
//    public static final int TYPE_3 = 0xff03;
//    public static final int TYPE_4 = 0xff04;
//    public static final int TYPE_MAIN = 0xffff;

    public PersonalMyOrderRecyclerAdapter(Context context, int srcId, List<OrderBean> results) {
        this.context = context;
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_personal_info_order_edit, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            bindType((MyViewHolder) holder, position);
        }
    }

    private void bindType(MyViewHolder holder, int position) {

        holder.item_recyc_type2.setLayoutManager(new FullyGridLayoutManager(holder.item_recyc_type2.getContext(), 1, GridLayoutManager.HORIZONTAL, false));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        List<OrderProductImgBean> results = new ArrayList<OrderProductImgBean>();
        String img = "http://pica.nipic.com/2007-10-09/200710994020530_2.jpg";
        results.add(new OrderProductImgBean( img));
        results.add(new OrderProductImgBean( img));
        results.add(new OrderProductImgBean( img));
        results.add(new OrderProductImgBean( img));
        results.add(new OrderProductImgBean( img));
        results.add(new OrderProductImgBean( img));
        holder.item_recyc_type2.setAdapter(new PersonalMyOrderRecyclerAdapterItem(context, results));
        holder.item_recyc_type2.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0){
//            return TYPE_1;
//        }else if (position == 1){
//            return TYPE_2;
//        }else if (position == 2){
//            return TYPE_3;
//        }else if (position == 3){
//            return TYPE_4;
//        }else {
//            return TYPE_MAIN;
//        }
        return TYPE_1;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
//                    switch (type){
//                        case TYPE_1:
//                        case TYPE_2:
//                        case TYPE_3:
//                        case TYPE_4:
//                            return gridManager.getSpanCount();
//                        default:
//                            return 1;
//                    }
                    return gridManager.getSpanCount();
                }
            });
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView item_recyc_type2;
        public MyViewHolder(final View itemView) {
            super(itemView);
            item_recyc_type2 = (RecyclerView) itemView.findViewById(R.id.rv_order_edit);
        }
    }
}