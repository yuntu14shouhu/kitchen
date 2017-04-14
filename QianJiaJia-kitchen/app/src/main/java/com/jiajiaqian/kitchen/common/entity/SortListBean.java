package com.jiajiaqian.kitchen.common.entity;

import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/4.
 * 仅用于前端解析分类数据用
 */

public class SortListBean implements Serializable{

    private String sortImageUrl;
    private String sortName;
    private ArrayList<ProductBean> sortList;

    public String getSortImageUrl() {
        return sortImageUrl;
    }

    public void setSortImageUrl(String sortImageUrl) {
        this.sortImageUrl = sortImageUrl;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public ArrayList<ProductBean> getSortList() {
        return sortList;
    }

    public void setSortList(ArrayList<ProductBean> sortList) {
        this.sortList = sortList;
    }
}
