package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-04-07 9:56
 * @email qianjiajia_2013@126.com
 */
public class MyOrderBean implements Serializable {

    private ArrayList<OrderBean> orderBeanList;

    public ArrayList<OrderBean> getOrderBeanList() {
        return orderBeanList;
    }

    public void setOrderBeanList(ArrayList<OrderBean> orderBeanList) {
        this.orderBeanList = orderBeanList;
    }
}