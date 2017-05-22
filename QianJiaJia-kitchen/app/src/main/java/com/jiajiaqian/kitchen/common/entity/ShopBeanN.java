package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 购物车beanN
 * @Date 2017-05-21 21:36
 * @email qianjiajia_2013@126.com
 */
public class ShopBeanN implements Serializable {


    /**
     * code : SUCCESS
     * message : null
     * data : [{"imageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/31730734-file_1489395785033_746b.jpg","productName":"去皮莴笋","price":2.9,"productNumber":1,"productId":"ff04e39740094196bb686ec731911f04","pageSize":10,"page":1,"firstResult":0},{"imageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/30831266-file_1489395785146_13ae0.jpg","productName":"香芋丁","price":6.9,"productNumber":1,"productId":"04e9a9f6f4a640f6ae000ea330eccebe","pageSize":10,"page":1,"firstResult":0}]
     * fieldErrors : {}
     */

    private String code;
    private Object message;
    private FieldErrorsBean fieldErrors;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public FieldErrorsBean getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(FieldErrorsBean fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class FieldErrorsBean {
    }

    public static class DataBean {
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