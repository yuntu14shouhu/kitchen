package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单详情bean
 * @Date 2017-03-27 18:03
 * @email qianjiajia_2013@126.com
 */
public class OrderDetailsBean implements Serializable {


    /**
     * product : [{"id":"e5c31a2486a54ff5bf82c2c29a1fb7a4","putawayDate":1489458778077,"kinds":"string","productName":"牛腩块","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/21189348-file_1489421103363_17999.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":48.4,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"牛肉","bigKeyClass":"肉类","keyword":"string"},{"id":"504ae486982b46e991bf6c975deca446","putawayDate":1489458853353,"kinds":"string","productName":"牛肉粒","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/75629652-file_1489458836689_4ae3.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":68.4,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"牛肉","bigKeyClass":"肉类","keyword":"string"},{"id":"38aaecba6d2b4ca09be68b637670177c","putawayDate":1489458873145,"kinds":"string","productName":"牛肉片","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/67589489-file_1489421103800_101ea.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":48.4,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"牛肉","bigKeyClass":"肉类","keyword":"string"}]
     * details : {"id":"f94300622c57487c98c51deb3fe1d4b5","userId":"a240611ed1174b4dbf3d6536517d3b6c","orderConsigneeName":"嘎嘎","orderConsigneePhone":"12223565","orderConsigneeAddress":"四川省成都市双流区","orderCarriage":0,"orderStatus":"1","orderCreateDate":1491467597090,"orderRef":"de0b9dfe628344ccbf6e625436a580bb","orderActualPayment":0,"orderTotalPayment":55.01,"orderProductNumber":1,"orderProductId":"e5c31a2486a54ff5bf82c2c29a1fb7a4,504ae486982b46e991bf6c975deca446,38aaecba6d2b4ca09be68b637670177c,"}
     */

    private DetailsBean details;
    private List<ProductBean> product;

    public DetailsBean getDetails() {
        return details;
    }

    public void setDetails(DetailsBean details) {
        this.details = details;
    }

    public List<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(List<ProductBean> product) {
        this.product = product;
    }

    public static class DetailsBean {
        /**
         * id : f94300622c57487c98c51deb3fe1d4b5
         * userId : a240611ed1174b4dbf3d6536517d3b6c
         * orderConsigneeName : 嘎嘎
         * orderConsigneePhone : 12223565
         * orderConsigneeAddress : 四川省成都市双流区
         * orderCarriage : 0
         * orderStatus : 1
         * orderCreateDate : 1491467597090
         * orderRef : de0b9dfe628344ccbf6e625436a580bb
         * orderActualPayment : 0
         * orderTotalPayment : 55.01
         * orderProductNumber : 1
         * orderProductId : e5c31a2486a54ff5bf82c2c29a1fb7a4,504ae486982b46e991bf6c975deca446,38aaecba6d2b4ca09be68b637670177c,
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

    public static class ProductBean {
        /**
         * id : e5c31a2486a54ff5bf82c2c29a1fb7a4
         * putawayDate : 1489458778077
         * kinds : string
         * productName : 牛腩块
         * productImageUrl : http://omkwzwj7w.bkt.clouddn.com/17-3-14/21189348-file_1489421103363_17999.jpg
         * status : 0
         * productTypes : string
         * producer : string
         * address : string
         * described : string
         * productionDate : 1489454726124
         * price : 48.4
         * discountPrice : 0
         * isDiscount : 0
         * limitNumber : 1
         * kindNumber : 0
         * startDate : 1489454726124
         * endDate : 1489454726124
         * carriage : 8
         * isGroupBuy : 0
         * groupBuyPrice : 0
         * groupBuyPersonNumber : 0
         * startGroupBuyDate : 1489454726124
         * endGroupBuyDate : 1489454726124
         * keyClass : 牛肉
         * bigKeyClass : 肉类
         * keyword : string
         */

        private String id;
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
        private double price;
        private int discountPrice;
        private int isDiscount;
        private int limitNumber;
        private int kindNumber;
        private long startDate;
        private long endDate;
        private int carriage;
        private int isGroupBuy;
        private int groupBuyPrice;
        private int groupBuyPersonNumber;
        private long startGroupBuyDate;
        private long endGroupBuyDate;
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

        public int getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(int discountPrice) {
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

        public int getGroupBuyPrice() {
            return groupBuyPrice;
        }

        public void setGroupBuyPrice(int groupBuyPrice) {
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
}