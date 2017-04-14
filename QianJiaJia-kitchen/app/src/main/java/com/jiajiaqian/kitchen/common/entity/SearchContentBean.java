package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 搜素内容bean
 * @Date 2017-04-11 17:18
 * @email qianjiajia_2013@126.com
 */
public class SearchContentBean implements Serializable{

    /**
     * code : SUCCESS
     * message : null
     * data : [{"id":"3826cebd08574fb3a56c2fb5d64a953e","searchType":1,"searchContent":"牛","userId":"a240611ed1174b4dbf3d6536517d3b6c","searchTime":1491902821660,"searchNumber":0},{"id":"28fda44763874714bbbe624e9f8d44bb","searchType":1,"searchContent":"糖","userId":"a240611ed1174b4dbf3d6536517d3b6c","searchTime":1491902669750,"searchNumber":0},{"id":"f0f5cd60b9b54b93bd35f9b37da11265","searchType":1,"searchContent":"米","userId":"a240611ed1174b4dbf3d6536517d3b6c","searchTime":1491902662445,"searchNumber":0},{"id":"c72dc88b41ab4bc1981abcf2545a8ea2","searchType":1,"searchContent":"菜","userId":"a240611ed1174b4dbf3d6536517d3b6c","searchTime":1491902654933,"searchNumber":0}]
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
         * id : 3826cebd08574fb3a56c2fb5d64a953e
         * searchType : 1
         * searchContent : 牛
         * userId : a240611ed1174b4dbf3d6536517d3b6c
         * searchTime : 1491902821660
         * searchNumber : 0
         */

        private String id;
        private int searchType;
        private String searchContent;
        private String userId;
        private long searchTime;
        private int searchNumber;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getSearchType() {
            return searchType;
        }

        public void setSearchType(int searchType) {
            this.searchType = searchType;
        }

        public String getSearchContent() {
            return searchContent;
        }

        public void setSearchContent(String searchContent) {
            this.searchContent = searchContent;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public long getSearchTime() {
            return searchTime;
        }

        public void setSearchTime(long searchTime) {
            this.searchTime = searchTime;
        }

        public int getSearchNumber() {
            return searchNumber;
        }

        public void setSearchNumber(int searchNumber) {
            this.searchNumber = searchNumber;
        }
    }

}