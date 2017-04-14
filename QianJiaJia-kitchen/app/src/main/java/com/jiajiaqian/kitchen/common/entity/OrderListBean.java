package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-04-08 15:20
 * @email qianjiajia_2013@126.com
 */
public class OrderListBean implements Serializable {
    private List<OrderBean> order;

    public List<OrderBean> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBean> order) {
        this.order = order;
    }
}