package com.jiajiaqian.kitchen.common.entity.microbean;

import java.io.Serializable;

/**
 * Created by jasonxu on 2017/2/26.
 * 商品对应字段
 */

public class ProductBean implements Serializable{

    private String productId;
    private String productName;
    private double productPrice; //原来价格
    private double discountPrice; //优惠价格
    private boolean isDiscount; //是否优惠
    private int limitSize; //用餐人数
    private int kindSize; //套餐种类，默认为1
    private String startDate;
    private String endDate;
    private String imageUrl;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getLimitSize() {
        return limitSize;
    }

    public void setLimitSize(int limitSize) {
        this.limitSize = limitSize;
    }

    public int getKindSize() {
        return kindSize;
    }

    public void setKindSize(int kindSize) {
        this.kindSize = kindSize;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }
}
