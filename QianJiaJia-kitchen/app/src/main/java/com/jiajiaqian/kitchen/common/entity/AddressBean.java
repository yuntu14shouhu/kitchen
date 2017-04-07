package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 11:39
 * @Description 收货地址
 */
public class AddressBean implements Serializable {

    private String id;
    private String userId;
    private String consigneeName;
    private String consigneePhone;
    private String consigneeAddress;
    private String city;
    private String houseNumber;
    private String defaultAddress;
    private int isDefault;//1代表默认，0代表非默认
    private String addressType;


    public AddressBean() {
    }

    public AddressBean(String consigneeName, String consigneeAddress, String consigneePhone, String addressType) {
        this.consigneeName = consigneeName;
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.addressType = addressType;
    }


    public AddressBean(String id, String userId, String consigneeName, String consigneePhone, String consigneeAddress, String city, String houseNumber, String defaultAddress, int isDefault, String addressType) {
        this.id = id;
        this.userId = userId;
        this.consigneeName = consigneeName;
        this.consigneePhone = consigneePhone;
        this.consigneeAddress = consigneeAddress;
        this.city = city;
        this.houseNumber = houseNumber;
        this.defaultAddress = defaultAddress;
        this.isDefault = isDefault;
        this.addressType = addressType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}