package com.jiajiaqian.kitchen.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.entity.AddressBean;

import java.util.List;

/**
 * Created by jasonxu on 2017/4/6.
 */

public class AddressListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AddressBean> mDataList;
    private int mResId;
    private Context mContext;
    private int mLastPosition = -1; //记录上一次选中的位置
    private AddressCallback mAddressCallback;

    public AddressListAdapter(List<AddressBean> mList, int resId, Context context, AddressCallback callback) {
        this.mDataList = mList;
        this.mResId = resId;
        this.mContext = context;
        mAddressCallback = callback;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mResId, parent, false);
        return new DataListVH(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataListVH viewHolder = (DataListVH) holder;
        resetViewState(viewHolder, position);
        initView(viewHolder, position);
        initEvents(viewHolder, position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private void initView(DataListVH dataListVH, int position) {
        if (mDataList != null && mDataList.size() > 0) {
            if (!TextUtils.isEmpty(mDataList.get(position).getConsigneeAddress())) {
                dataListVH.mAddressLayout.setVisibility(View.VISIBLE);
                dataListVH.mAddressTv.setText(mDataList.get(position).getConsigneeAddress());
            }else {
                dataListVH.mAddressLayout.setVisibility(View.GONE);
            }
        }
    }

    private void initEvents(final DataListVH dataListVH, final int position) {

        dataListVH.mAddressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLastPosition = position;
                mAddressCallback.onAddressLSelectClick(mDataList.get(position), position);
                notifyDataSetChanged();
            }
        });
    }

    private void resetViewState(DataListVH dataListVH, int position) {
        if (position != mLastPosition) {
            dataListVH.mCheckView.setChecked(false);
        } else {
            dataListVH.mCheckView.setChecked(true);
        }
    }

    private static class DataListVH extends RecyclerView.ViewHolder {

        private TextView mAddressTv;
        private CheckBox mCheckView;
        private LinearLayout mAddressLayout;

        DataListVH(View itemView) {
            super(itemView);
            mAddressTv = (TextView) itemView.findViewById(R.id.tv_address);
            mCheckView = (CheckBox) itemView.findViewById(R.id.cb_view);
            mAddressLayout = (LinearLayout) itemView.findViewById(R.id.ll_address_layout);

        }
    }

    public interface AddressCallback {

        void onAddressLSelectClick(AddressBean addressBean, int position);

    }
}
