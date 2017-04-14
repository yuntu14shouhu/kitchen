package com.jiajiaqian.kitchen.common.entity.microbean;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 商品详情bean
 * @Date 2017-03-28 18:01
 * @email qianjiajia_2013@126.com
 */
public class ProductDetailsBean implements Serializable {

    private int imgProductDetails;//商品图片
    private String nameProductDetails;//商品名称
    private String smallClassProductDetails;//商品小类别
    private double priceProductDetails;//商品价格
    private int numberProductDetails;//商品数量
    private String namePinProductDetails;//商品品名
    private String addressProductDetails;//商品产地
    private String putawayDate;//商品上架日期
    private String typeProductDetails;//商品规格
    private String manufactureDateProductDetails;//商品生产日期
    private String describedProductDetails;//商品描述

    public ProductDetailsBean() {
    }

    public ProductDetailsBean(int imgProductDetails, String nameProductDetails, String smallClassProductDetails, double priceProductDetails, int numberProductDetails, String addressProductDetails, String putawayDate, String typeProductDetails, String manufactureDateProductDetails, String describedProductDetails) {
        this.imgProductDetails = imgProductDetails;
        this.nameProductDetails = nameProductDetails;
        this.smallClassProductDetails = smallClassProductDetails;
        this.priceProductDetails = priceProductDetails;
        this.numberProductDetails = numberProductDetails;
        this.addressProductDetails = addressProductDetails;
        this.putawayDate = putawayDate;
        this.typeProductDetails = typeProductDetails;
        this.manufactureDateProductDetails = manufactureDateProductDetails;
        this.describedProductDetails = describedProductDetails;
    }

    public ProductDetailsBean(int imgProductDetails, String nameProductDetails, String smallClassProductDetails, double priceProductDetails, int numberProductDetails, String namePinProductDetails, String addressProductDetails, String putawayDate, String typeProductDetails, String manufactureDateProductDetails, String describedProductDetails) {
        this.imgProductDetails = imgProductDetails;
        this.nameProductDetails = nameProductDetails;
        this.smallClassProductDetails = smallClassProductDetails;
        this.priceProductDetails = priceProductDetails;
        this.numberProductDetails = numberProductDetails;
        this.namePinProductDetails = namePinProductDetails;
        this.addressProductDetails = addressProductDetails;
        this.putawayDate = putawayDate;
        this.typeProductDetails = typeProductDetails;
        this.manufactureDateProductDetails = manufactureDateProductDetails;
        this.describedProductDetails = describedProductDetails;
    }

    public String getNamePinProductDetails() {
        return namePinProductDetails;
    }

    public void setNamePinProductDetails(String namePinProductDetails) {
        this.namePinProductDetails = namePinProductDetails;
    }

    public int getImgProductDetails() {
        return imgProductDetails;
    }

    public void setImgProductDetails(int imgProductDetails) {
        this.imgProductDetails = imgProductDetails;
    }

    public String getNameProductDetails() {
        return nameProductDetails;
    }

    public void setNameProductDetails(String nameProductDetails) {
        this.nameProductDetails = nameProductDetails;
    }

    public String getSmallClassProductDetails() {
        return smallClassProductDetails;
    }

    public void setSmallClassProductDetails(String smallClassProductDetails) {
        this.smallClassProductDetails = smallClassProductDetails;
    }

    public double getPriceProductDetails() {
        return priceProductDetails;
    }

    public void setPriceProductDetails(double priceProductDetails) {
        this.priceProductDetails = priceProductDetails;
    }

    public int getNumberProductDetails() {
        return numberProductDetails;
    }

    public void setNumberProductDetails(int numberProductDetails) {
        this.numberProductDetails = numberProductDetails;
    }

    public String getAddressProductDetails() {
        return addressProductDetails;
    }

    public void setAddressProductDetails(String addressProductDetails) {
        this.addressProductDetails = addressProductDetails;
    }

    public String getPutawayDate() {
        return putawayDate;
    }

    public void setPutawayDate(String putawayDate) {
        this.putawayDate = putawayDate;
    }

    public String getTypeProductDetails() {
        return typeProductDetails;
    }

    public void setTypeProductDetails(String typeProductDetails) {
        this.typeProductDetails = typeProductDetails;
    }

    public String getManufactureDateProductDetails() {
        return manufactureDateProductDetails;
    }

    public void setManufactureDateProductDetails(String manufactureDateProductDetails) {
        this.manufactureDateProductDetails = manufactureDateProductDetails;
    }

    public String getDescribedProductDetails() {
        return describedProductDetails;
    }

    public void setDescribedProductDetails(String describedProductDetails) {
        this.describedProductDetails = describedProductDetails;
    }

    @Override
    public String toString() {
        return "ProductDetailsQueryBean{" +
                "imgProductDetails=" + imgProductDetails +
                ", nameProductDetails='" + nameProductDetails + '\'' +
                ", smallClassProductDetails='" + smallClassProductDetails + '\'' +
                ", priceProductDetails=" + priceProductDetails +
                ", numberProductDetails=" + numberProductDetails +
                ", namePinProductDetails='" + namePinProductDetails + '\'' +
                ", addressProductDetails='" + addressProductDetails + '\'' +
                ", putawayDate='" + putawayDate + '\'' +
                ", typeProductDetails='" + typeProductDetails + '\'' +
                ", manufactureDateProductDetails='" + manufactureDateProductDetails + '\'' +
                ", describedProductDetails='" + describedProductDetails + '\'' +
                '}';
    }
}