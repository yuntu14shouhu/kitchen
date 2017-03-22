package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单bean
 * @Date 2017-03-17 14:40
 * @email qianjiajia_2013@126.com
 */
public class OrderBean implements Serializable {

    private String orderDate;
    private int logoImg;
    private String totalString;
    private double totalPrice;

    public OrderBean(String orderDate, int logoImg) {
        this.orderDate = orderDate;
        this.logoImg = logoImg;
    }

    public OrderBean(String orderDate, int logoImg, double totalPrice) {
        this.totalPrice = totalPrice;
        this.logoImg = logoImg;
        this.orderDate = orderDate;
    }

    public OrderBean(String orderDate, int logoImg, String totalString, double totalPrice) {
        this.orderDate = orderDate;
        this.logoImg = logoImg;
        this.totalString = totalString;
        this.totalPrice = totalPrice;
    }

    public String getTotalString() {
        return totalString;
    }

    public void setTotalString(String totalString) {
        this.totalString = totalString;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(int logoImg) {
        this.logoImg = logoImg;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "OrderBean{" +
                "orderDate=" + orderDate +
                ", logoImg=" + logoImg +
                ", totalPrice=" + totalPrice +
                '}';
    }

    /**
     * 保留两位小数点
     */
    public static String S2places(float num){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(num);
    }

    public static float F2places(float num){
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(2).floatValue();
    }


}