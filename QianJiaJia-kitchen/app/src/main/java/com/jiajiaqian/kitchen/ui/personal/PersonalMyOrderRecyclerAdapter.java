package com.jiajiaqian.kitchen.ui.personal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.OrderBean;
import com.jiajiaqian.kitchen.ui.personal.adapter.FullyGridLayoutManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单Adapter
 * @Date 2017-03-22 9:56
 * @email qianjiajia_2013@126.com
 */
public class PersonalMyOrderRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<OrderBean> orderbeanList;

    public List<OrderBean> getResults() {
        return orderbeanList;
    }

    public static final int TYPE_1 = 0xff01;

    public PersonalMyOrderRecyclerAdapter(Context context, int srcId, List<OrderBean> orderbeanList) {
        this.context = context;
        this.orderbeanList = orderbeanList;
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

    private void bindType(final MyViewHolder holder, final int position) {

        if(orderbeanList != null && orderbeanList.size() > 0) {

            Log.e("--------------", getStrTime(orderbeanList.get(position).getDate() + ""));
            if (!TextUtils.isEmpty(orderbeanList.get(position).getDate() + "")) {
                holder.orderDate.setText(getStrTime(orderbeanList.get(position).getDate() + ""));
            }

            if (orderbeanList.get(position).getTotal() != 0) {
                holder.orderTotal.setText(orderbeanList.get(position).getTotal() + "");
            }
            Log.e("getProduct", "bindType: "+orderbeanList.get(position).getProduct() );
            holder.item_recyc_type2.setLayoutManager(new FullyGridLayoutManager(holder.item_recyc_type2.getContext(), 1, GridLayoutManager.HORIZONTAL, false));
            holder.item_recyc_type2.setAdapter(new PersonalMyOrderRecyclerAdapterItem(context,orderbeanList.get(position).getProduct(),orderbeanList.get(position).getId() ));
        }
      holder.buttonOrderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PersonalMyOrderDetailsActivity.class);
                intent.putExtra("orderId",orderbeanList.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.item_recyc_type2.setNestedScrollingEnabled(false);
    }


    @Override
    public int getItemCount() {
        return orderbeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_1;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    return gridManager.getSpanCount();
                }
            });
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView item_recyc_type2;
        private TextView orderDate;
        private TextView orderTotal;
        private Button buttonOrderDetails;

        public MyViewHolder(final View itemView) {
            super(itemView);
            item_recyc_type2 = (RecyclerView) itemView.findViewById(R.id.rv_order_edit);
            orderDate = (TextView) itemView.findViewById(R.id.tv_order_date);
            orderTotal = (TextView) itemView.findViewById(R.id.tv_order_total);
            buttonOrderDetails = (Button) itemView.findViewById(R.id.bt_personal_info_order_details);
        }
    }

    /**
     * 将时间戳转换成时间格式yyyy-MM-dd hh:mm:ss
     */
    public static String getStrTime(String timeStamp){
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long  l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));//单位秒
        return timeString;
    }
}