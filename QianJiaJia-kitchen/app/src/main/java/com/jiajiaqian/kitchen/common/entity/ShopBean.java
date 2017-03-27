package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 购物车bean
 * @Date 2017-03-23 15:40
 * @email qianjiajia_2013@126.com
 */
public class ShopBean implements Serializable {

    private int productImg;
    private String productName;
    private int productNumber;
    private double productPrice;


    public ShopBean() {
    }

    public ShopBean(int productImg, String productName, int productNumber, double productPrice) {

        this.productImg = productImg;
        this.productName = productName;
        this.productNumber = productNumber;
        this.productPrice = productPrice;

    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    @Override
    public String toString() {
        return "ShopBean{" +
                "productImg=" + productImg +
                ", productName='" + productName + '\'' +
                ", productNumber=" + productNumber +
                ", productPrice=" + productPrice +
                '}';
    }
}