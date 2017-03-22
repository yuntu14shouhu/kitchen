package com.jiajiaqian.kitchen.ui.personal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description ListView万能适配器
 * @Date 2017-03-16 10:05
 * @email qianjiajia_2013@126.com
 */
public abstract class CommonAdaper<T> extends BaseAdapter {


        private Context context;
        private List<T> list;
        private LayoutInflater inflater;
        private int itemLayoutId;


        public CommonAdaper(Context context, List<T> list,int itemLayoutId) {
            this.context = context;
            this.list = list;
            this.itemLayoutId = itemLayoutId;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public T getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = getViewHolder(position,convertView,parent);
            convert(holder,getItem(position));
            return holder.getConvertView();
        }

        public abstract void convert(ViewHolder holder, T item);

        private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent){
            return ViewHolder.get(context,convertView,parent,itemLayoutId,position);
        }

}