package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-04-07 11:03
 * @email qianjiajia_2013@126.com
 */
public class OrderProductImgBeanList implements Serializable {

    ArrayList<OrderProductImgBean> orderProductImgBean;

    public ArrayList<OrderProductImgBean> getOrderProductImgBean() {
        return orderProductImgBean;
    }

    public void setOrderProductImgBean(ArrayList<OrderProductImgBean> orderProductImgBean) {
        this.orderProductImgBean = orderProductImgBean;
    }
}