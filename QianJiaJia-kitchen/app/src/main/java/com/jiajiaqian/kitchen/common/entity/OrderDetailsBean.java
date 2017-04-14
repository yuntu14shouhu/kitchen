package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单详情bean
 * @Date 2017-03-27 18:03
 * @email qianjiajia_2013@126.com
 */
public class OrderDetailsBean implements Serializable {

    private int productImgDetails;
    private String productNameDetails;
    private double productPriceDetails;
    private int productNumberDetails;
    private String productDefaultDetails;

    public OrderDetailsBean() {
    }

    public OrderDetailsBean(int productImgDetails, String productNameDetails, double productPriceDetails, int productNumberDetails, String productDefaultDetails) {
        this.productImgDetails = productImgDetails;
        this.productNameDetails = productNameDetails;
        this.productPriceDetails = productPriceDetails;
        this.productNumberDetails = productNumberDetails;
        this.productDefaultDetails = productDefaultDetails;
    }

    public int getProductImgDetails() {
        return productImgDetails;
    }

    public void setProductImgDetails(int productImgDetails) {
        this.productImgDetails = productImgDetails;
    }

    public String getProductNameDetails() {
        return productNameDetails;
    }

    public void setProductNameDetails(String productNameDetails) {
        this.productNameDetails = productNameDetails;
    }

    public double getProductPriceDetails() {
        return productPriceDetails;
    }

    public void setProductPriceDetails(double productPriceDetails) {
        this.productPriceDetails = productPriceDetails;
    }

    public int getProductNumberDetails() {
        return productNumberDetails;
    }

    public void setProductNumberDetails(int productNumberDetails) {
        this.productNumberDetails = productNumberDetails;
    }

    public String getProductDefaultDetails() {
        return productDefaultDetails;
    }

    public void setProductDefaultDetails(String productDefaultDetails) {
        this.productDefaultDetails = productDefaultDetails;
    }

    @Override
    public String toString() {
        return "MyOrderDetailsBean{" +
                "productImgDetails=" + productImgDetails +
                ", productNameDetails='" + productNameDetails + '\'' +
                ", productPriceDetails=" + productPriceDetails +
                ", productNumberDetails=" + productNumberDetails +
                ", productDefaultDetails='" + productDefaultDetails + '\'' +
                '}';
    }
}