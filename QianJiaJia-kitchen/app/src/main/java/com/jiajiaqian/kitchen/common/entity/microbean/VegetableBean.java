package com.jiajiaqian.kitchen.common.entity.microbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jasonxu on 2017/3/20.
 */

public class VegetableBean implements Serializable{

    @SerializedName("ye_cai_lei")
    private ArrayList<ProductBean> yeCaiLei;
    @SerializedName("qie_guo_lei")
    private ArrayList<ProductBean> qieGuoLei;
    @SerializedName("jing_shi_shu")
    private ArrayList<ProductBean> jingShiShu;
    @SerializedName("dou_zhi_pin")
    private ArrayList<ProductBean> douZhiPin;
    @SerializedName("shi_ling_shu_cai")
    private ArrayList<ProductBean> shiLingShuCai;
    @SerializedName("jing_pin_shu_cai")
    private ArrayList<ProductBean> jingPinShuCai;
    @SerializedName("gen_jing_lei")
    private ArrayList<ProductBean> genJingLei;
    @SerializedName("jun_gu_lei")
    private ArrayList<ProductBean> junGuLei;

    public ArrayList<ProductBean> getYeCaiLei() {
        return yeCaiLei;
    }

    public void setYeCaiLei(ArrayList<ProductBean> yeCaiLei) {
        this.yeCaiLei = yeCaiLei;
    }

    public ArrayList<ProductBean> getQieGuoLei() {
        return qieGuoLei;
    }

    public void setQieGuoLei(ArrayList<ProductBean> qieGuoLei) {
        this.qieGuoLei = qieGuoLei;
    }

    public ArrayList<ProductBean> getJingShiShu() {
        return jingShiShu;
    }

    public void setJingShiShu(ArrayList<ProductBean> jingShiShu) {
        this.jingShiShu = jingShiShu;
    }

    public ArrayList<ProductBean> getDouZhiPin() {
        return douZhiPin;
    }

    public void setDouZhiPin(ArrayList<ProductBean> douZhiPin) {
        this.douZhiPin = douZhiPin;
    }

    public ArrayList<ProductBean> getShiLingShuCai() {
        return shiLingShuCai;
    }

    public void setShiLingShuCai(ArrayList<ProductBean> shiLingShuCai) {
        this.shiLingShuCai = shiLingShuCai;
    }

    public ArrayList<ProductBean> getJingPinShuCai() {
        return jingPinShuCai;
    }

    public void setJingPinShuCai(ArrayList<ProductBean> jingPinShuCai) {
        this.jingPinShuCai = jingPinShuCai;
    }

    public ArrayList<ProductBean> getGenJingLei() {
        return genJingLei;
    }

    public void setGenJingLei(ArrayList<ProductBean> genJingLei) {
        this.genJingLei = genJingLei;
    }

    public ArrayList<ProductBean> getJunGuLei() {
        return junGuLei;
    }

    public void setJunGuLei(ArrayList<ProductBean> junGuLei) {
        this.junGuLei = junGuLei;
    }
}
