//package com.jiajiaqian.kitchen.ui.personal;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.jiajiaqian.kitchen.R;
//import com.jiajiaqian.kitchen.common.entity.AddressBean;
//
//import java.util.List;
//
///**
// * @author qianjiajia
// * @version 1.0
// * @Date 2017-03-09 11:29
// * @Description 收货地址列表适配器
// */
//public class PersonalAddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private List<AddressBean> mAddressBeanList;
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_personal_info_address_item,parent,false);
//        return new DataListVH(view);
//    }
//
//    private static class DataListVH extends RecyclerView.ViewHolder{
//        DataListVH(View itemView) {
//            super(itemView);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        DataListVH viewHolder = (DataListVH)holder;
//        initView(viewHolder,position);
//        initEvents(viewHolder,position);
//    }
//
//    private void initView(DataListVH dataListVH,int position){
//
//    }
//
//    private void initEvents(DataListVH viewHolder, int position) {
//    }
//
//    @Override
//    public int getItemCount() {
//        return mAddressBeanList.size();
//    }
//}