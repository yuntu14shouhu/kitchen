package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-04-10 17:46
 * @email qianjiajia_2013@126.com
 */
public class DetailsBean implements Serializable {

    /**
     * id : e654298fce4e42b5965723bdea701313
     * userId : a240611ed1174b4dbf3d6536517d3b6c
     * orderConsigneeName : 云图
     * orderConsigneePhone : 18482173219
     * orderConsigneeAddress : 四川省成都市一环路南四段16号
     * orderCarriage : 0
     * orderStatus : 1
     * orderCreateDate : 1491467356811
     * orderRef : 4d867aa615f8446dbe58ce31ff807e09
     * orderActualPayment : 0
     * orderTotalPayment : 1.11
     * orderProductNumber : 1
     * orderProductId : 5dab487bbe784d989638a00e0ebb00dd,25c73f8774af4db5a6cdbb1b08dd5ff2,
     */

    private String id;
    private String userId;
    private String orderConsigneeName;
    private String orderConsigneePhone;
    private String orderConsigneeAddress;
    private int orderCarriage;
    private String orderStatus;
    private long orderCreateDate;
    private String orderRef;
    private int orderActualPayment;
    private double orderTotalPayment;
    private int orderProductNumber;
    private String orderProductId;

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

    public String getOrderConsigneeName() {
        return orderConsigneeName;
    }

    public void setOrderConsigneeName(String orderConsigneeName) {
        this.orderConsigneeName = orderConsigneeName;
    }

    public String getOrderConsigneePhone() {
        return orderConsigneePhone;
    }

    public void setOrderConsigneePhone(String orderConsigneePhone) {
        this.orderConsigneePhone = orderConsigneePhone;
    }

    public String getOrderConsigneeAddress() {
        return orderConsigneeAddress;
    }

    public void setOrderConsigneeAddress(String orderConsigneeAddress) {
        this.orderConsigneeAddress = orderConsigneeAddress;
    }

    public int getOrderCarriage() {
        return orderCarriage;
    }

    public void setOrderCarriage(int orderCarriage) {
        this.orderCarriage = orderCarriage;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(long orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public int getOrderActualPayment() {
        return orderActualPayment;
    }

    public void setOrderActualPayment(int orderActualPayment) {
        this.orderActualPayment = orderActualPayment;
    }

    public double getOrderTotalPayment() {
        return orderTotalPayment;
    }

    public void setOrderTotalPayment(double orderTotalPayment) {
        this.orderTotalPayment = orderTotalPayment;
    }

    public int getOrderProductNumber() {
        return orderProductNumber;
    }

    public void setOrderProductNumber(int orderProductNumber) {
        this.orderProductNumber = orderProductNumber;
    }

    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId;
    }
}