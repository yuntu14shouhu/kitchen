package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单详情Bean
 * @Date 2017-04-10 17:40
 * @email qianjiajia_2013@126.com
 */
public class MyOrderDetailsBean implements Serializable{


    /**
     * product : [{"imageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/31730734-file_1489395785033_746b.jpg","productName":"去皮莴笋","price":2.9,"productNumber":1,"productId":"ff04e39740094196bb686ec731911f04","pageSize":10,"page":1,"firstResult":0},{"imageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/30831266-file_1489395785146_13ae0.jpg","productName":"香芋丁","price":6.9,"productNumber":1,"productId":"04e9a9f6f4a640f6ae000ea330eccebe","pageSize":10,"page":1,"firstResult":0}]
     * details : {"id":"07a5292143654c108b1d6a6a9188891c","userId":"2664c4233dbb4f109631c2d1b6246774","orderConsigneeName":"发货今年","orderConsigneePhone":"789","orderConsigneeAddress":"山西省督公湖支付宝","orderCarriage":0,"orderStatus":"1","orderCreateDate":1495383156592,"orderRef":"2a292b1d56104e3e8a1e9c1d1cd0d6da","orderActualPayment":9.8,"orderTotalPayment":9.8,"orderProductNumber":null,"orderProductId":"ff04e39740094196bb686ec731911f04,04e9a9f6f4a640f6ae000ea330eccebe"}
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
         * id : 07a5292143654c108b1d6a6a9188891c
         * userId : 2664c4233dbb4f109631c2d1b6246774
         * orderConsigneeName : 发货今年
         * orderConsigneePhone : 789
         * orderConsigneeAddress : 山西省督公湖支付宝
         * orderCarriage : 0
         * orderStatus : 1
         * orderCreateDate : 1495383156592
         * orderRef : 2a292b1d56104e3e8a1e9c1d1cd0d6da
         * orderActualPayment : 9.8
         * orderTotalPayment : 9.8
         * orderProductNumber : null
         * orderProductId : ff04e39740094196bb686ec731911f04,04e9a9f6f4a640f6ae000ea330eccebe
         */

        private String id;
        private String userId;
        private String orderConsigneeName;
        private String orderConsigneePhone;
        private String orderConsigneeAddress;
        private double orderCarriage;
        private String orderStatus;
        private long orderCreateDate;
        private String orderRef;
        private double orderActualPayment;
        private double orderTotalPayment;
        private Object orderProductNumber;
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

        public double getOrderCarriage() {
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

        public double getOrderActualPayment() {
            return orderActualPayment;
        }

        public void setOrderActualPayment(double orderActualPayment) {
            this.orderActualPayment = orderActualPayment;
        }

        public double getOrderTotalPayment() {
            return orderTotalPayment;
        }

        public void setOrderTotalPayment(double orderTotalPayment) {
            this.orderTotalPayment = orderTotalPayment;
        }

        public Object getOrderProductNumber() {
            return orderProductNumber;
        }

        public void setOrderProductNumber(Object orderProductNumber) {
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
         * imageUrl : http://omkwzwj7w.bkt.clouddn.com/17-3-13/31730734-file_1489395785033_746b.jpg
         * productName : 去皮莴笋
         * price : 2.9
         * productNumber : 1
         * productId : ff04e39740094196bb686ec731911f04
         * pageSize : 10
         * page : 1
         * firstResult : 0
         */

        private String imageUrl;
        private String productName;
        private double price;
        private int productNumber;
        private String productId;
        private int pageSize;
        private int page;
        private int firstResult;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(int productNumber) {
            this.productNumber = productNumber;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getFirstResult() {
            return firstResult;
        }

        public void setFirstResult(int firstResult) {
            this.firstResult = firstResult;
        }
    }
}