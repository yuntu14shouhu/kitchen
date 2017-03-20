package com.jiajiaqian.kitchen.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jasonxu on 2017/2/26.
 */

public class HomeGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ProductBean> mDataList;
    private int mResId;
    private Context mContext;

    public HomeGridAdapter(List<ProductBean> mList, int resId, Context context){
        this.mDataList = mList;
        this.mResId = resId;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mResId,parent,false);
        return new DataListVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataListVH viewHolder = (DataListVH)holder;
        initView(viewHolder,position);
        initEvents(viewHolder,position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private void initView(DataListVH dataListVH,int position){

    }

    private void initEvents(DataListVH dataListVH,int position) {

    }

    private static class DataListVH extends RecyclerView.ViewHolder{

        DataListVH(View itemView) {
            super(itemView);
        }
    }
}
