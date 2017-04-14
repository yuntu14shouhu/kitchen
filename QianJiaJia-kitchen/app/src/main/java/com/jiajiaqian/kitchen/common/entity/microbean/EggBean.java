package com.jiajiaqian.kitchen.common.entity.microbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/20.
 */

public class EggBean implements Serializable{

    @SerializedName("ji_ya_bu_jian")
    private ArrayList<ProductBean> jiYaBuJian;
    @SerializedName("ji_ya_zheng_qin")
    private ArrayList<ProductBean> jiYaZhengQin;
    @SerializedName("xian_dan")
    private ArrayList<ProductBean> xianDan;
    @SerializedName("jia_gong_dan")
    private ArrayList<ProductBean> jiaGongDan;

    public ArrayList<ProductBean> getJiYaBuJian() {
        return jiYaBuJian;
    }

    public void setJiYaBuJian(ArrayList<ProductBean> jiYaBuJian) {
        this.jiYaBuJian = jiYaBuJian;
    }

    public ArrayList<ProductBean> getJiYaZhengQin() {
        return jiYaZhengQin;
    }

    public void setJiYaZhengQin(ArrayList<ProductBean> jiYaZhengQin) {
        this.jiYaZhengQin = jiYaZhengQin;
    }

    public ArrayList<ProductBean> getXianDan() {
        return xianDan;
    }

    public void setXianDan(ArrayList<ProductBean> xianDan) {
        this.xianDan = xianDan;
    }

    public ArrayList<ProductBean> getJiaGongDan() {
        return jiaGongDan;
    }

    public void setJiaGongDan(ArrayList<ProductBean> jiaGongDan) {
        this.jiaGongDan = jiaGongDan;
    }
}
