package com.jiajiaqian.kitchen.common.entity.microbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/20.
 */

public class MeatBean implements Serializable{

    @SerializedName("rou_zhi_pin")
    private ArrayList<ProductBean> rouZhiPin;
    @SerializedName("yang_rou")
    private ArrayList<ProductBean> yangRou;
    @SerializedName("niu_pai")
    private ArrayList<ProductBean> niuPai;
    @SerializedName("niu_rou")
    private ArrayList<ProductBean> niuRou;
    @SerializedName("xin_xian_rou")
    private ArrayList<ProductBean> xinXianRou;
    @SerializedName("zhu_rou")
    private ArrayList<ProductBean> zhuRou;

    public ArrayList<ProductBean> getRouZhiPin() {
        return rouZhiPin;
    }

    public void setRouZhiPin(ArrayList<ProductBean> rouZhiPin) {
        this.rouZhiPin = rouZhiPin;
    }

    public ArrayList<ProductBean> getYangRou() {
        return yangRou;
    }

    public void setYangRou(ArrayList<ProductBean> yangRou) {
        this.yangRou = yangRou;
    }

    public ArrayList<ProductBean> getNiuPai() {
        return niuPai;
    }

    public void setNiuPai(ArrayList<ProductBean> niuPai) {
        this.niuPai = niuPai;
    }

    public ArrayList<ProductBean> getNiuRou() {
        return niuRou;
    }

    public void setNiuRou(ArrayList<ProductBean> niuRou) {
        this.niuRou = niuRou;
    }

    public ArrayList<ProductBean> getXinXianRou() {
        return xinXianRou;
    }

    public void setXinXianRou(ArrayList<ProductBean> xinXianRou) {
        this.xinXianRou = xinXianRou;
    }

    public ArrayList<ProductBean> getZhuRou() {
        return zhuRou;
    }

    public void setZhuRou(ArrayList<ProductBean> zhuRou) {
        this.zhuRou = zhuRou;
    }
}
