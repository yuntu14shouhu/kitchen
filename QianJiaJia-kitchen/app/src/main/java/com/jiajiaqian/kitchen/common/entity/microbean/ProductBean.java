package com.jiajiaqian.kitchen.common.entity.microbean;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/20.
 */

public class ProductBean implements Serializable{

    private String id ;
    private long putawayDate;
    private String kinds;
    private String productName;
    private String productImageUrl;
    private int status;
    private String productTypes;
    private String producer;
    private String address;
    private String described;
    private long productionDate;
    private double  price;
    private double discountPrice;
    private int isDiscount; //0非优惠商品，1优惠商品
    private int limitNumber;
    private int kindNumber;
    private long startDate;
    private long endDate;
    private int carriage;
    private int isGroupBuy; //0非团购商品，1团购商品
    private double groupBuyPrice;
    private int  groupBuyPersonNumber;
    private long  startGroupBuyDate;
    private long  endGroupBuyDate;
    private String keyClass;
    private String bigKeyClass;
    private String keyword;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPutawayDate() {
        return putawayDate;
    }

    public void setPutawayDate(long putawayDate) {
        this.putawayDate = putawayDate;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(String productTypes) {
        this.productTypes = productTypes;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    public long getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(long productionDate) {
        this.productionDate = productionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(int isDiscount) {
        this.isDiscount = isDiscount;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

    public int getKindNumber() {
        return kindNumber;
    }

    public void setKindNumber(int kindNumber) {
        this.kindNumber = kindNumber;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int getCarriage() {
        return carriage;
    }

    public void setCarriage(int carriage) {
        this.carriage = carriage;
    }

    public int getIsGroupBuy() {
        return isGroupBuy;
    }

    public void setIsGroupBuy(int isGroupBuy) {
        this.isGroupBuy = isGroupBuy;
    }

    public double getGroupBuyPrice() {
        return groupBuyPrice;
    }

    public void setGroupBuyPrice(double groupBuyPrice) {
        this.groupBuyPrice = groupBuyPrice;
    }

    public int getGroupBuyPersonNumber() {
        return groupBuyPersonNumber;
    }

    public void setGroupBuyPersonNumber(int groupBuyPersonNumber) {
        this.groupBuyPersonNumber = groupBuyPersonNumber;
    }

    public long getStartGroupBuyDate() {
        return startGroupBuyDate;
    }

    public void setStartGroupBuyDate(long startGroupBuyDate) {
        this.startGroupBuyDate = startGroupBuyDate;
    }

    public long getEndGroupBuyDate() {
        return endGroupBuyDate;
    }

    public void setEndGroupBuyDate(long endGroupBuyDate) {
        this.endGroupBuyDate = endGroupBuyDate;
    }

    public String getKeyClass() {
        return keyClass;
    }

    public void setKeyClass(String keyClass) {
        this.keyClass = keyClass;
    }

    public String getBigKeyClass() {
        return bigKeyClass;
    }

    public void setBigKeyClass(String bigKeyClass) {
        this.bigKeyClass = bigKeyClass;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
