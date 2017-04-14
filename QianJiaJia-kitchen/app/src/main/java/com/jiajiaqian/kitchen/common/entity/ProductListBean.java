package com.jiajiaqian.kitchen.common.entity;

import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/5.
 * 优惠套餐，人气推荐，劲爆团购
 */

public class ProductListBean implements Serializable{

    private String code;
    private String message;
    private ArrayList<ProductBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ProductBean> getData() {
        return data;
    }

    public void setData(ArrayList<ProductBean> data) {
        this.data = data;
    }
}
