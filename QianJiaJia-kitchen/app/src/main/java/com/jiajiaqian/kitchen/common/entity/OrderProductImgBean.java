package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 显示订单中全部商品图片
 * @Date 2017-03-17 14:54
 * @email qianjiajia_2013@126.com
 */
public class OrderProductImgBean implements Serializable {

    private String productImg;

    public OrderProductImgBean() {
    }

    public OrderProductImgBean(String productImg) {
        this.productImg = productImg;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @Override
    public String toString() {
        return "OrderProductImgBean{" +
                "productImg=" + productImg +
                '}';
    }
}