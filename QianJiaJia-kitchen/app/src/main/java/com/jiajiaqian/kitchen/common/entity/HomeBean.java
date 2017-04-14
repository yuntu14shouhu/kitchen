package com.jiajiaqian.kitchen.common.entity;

import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;
import com.jiajiaqian.kitchen.common.entity.microbean.SlideBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/2/26.
 * 首页服务器返回的数据源解析对应的bean
 */

public class HomeBean implements Serializable{

    private ArrayList<AddressBean> address;
    private ArrayList<SlideBean> slide;
    private ArrayList<ProductBean> discount;
    private ArrayList<ProductBean> recommend;
    private ArrayList<ProductBean> group;

    public ArrayList<AddressBean> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<AddressBean> address) {
        this.address = address;
    }

    public ArrayList<SlideBean> getSlide() {
        return slide;
    }

    public void setSlide(ArrayList<SlideBean> slide) {
        this.slide = slide;
    }

    public ArrayList<ProductBean> getDiscount() {
        return discount;
    }

    public void setDiscount(ArrayList<ProductBean> discount) {
        this.discount = discount;
    }

    public ArrayList<ProductBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(ArrayList<ProductBean> recommend) {
        this.recommend = recommend;
    }

    public ArrayList<ProductBean> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<ProductBean> group) {
        this.group = group;
    }
}
