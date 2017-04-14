package com.jiajiaqian.kitchen.common.entity.microbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/20.
 */

public class FruitBean implements Serializable{

    @SerializedName("pu_tao_ti_zi")
    private ArrayList<ProductBean> puTaoTiZi;
    @SerializedName("qi_yi_guo")
    private ArrayList<ProductBean> qiYiGuo;
    @SerializedName("gan_ju_cheng_you")
    private ArrayList<ProductBean> ganJuChengYou;
    @SerializedName("niu_you_guo")
    private ArrayList<ProductBean> niuYouGuo;
    @SerializedName("shi_ling_shui_guo")
    private ArrayList<ProductBean> shiLingShuiGuo;
    @SerializedName("re_dai_shui_guo")
    private ArrayList<ProductBean> reDaiShuiGuo;
    @SerializedName("ye_zi")
    private ArrayList<ProductBean> yeZi;
    @SerializedName("xiang_jiao")
    private ArrayList<ProductBean> xiangJiao;
    @SerializedName("ping_guo_li")
    private ArrayList<ProductBean> pingGuoLi;
    @SerializedName("ye_qing")
    private ArrayList<ProductBean> yeQing;

    public ArrayList<ProductBean> getPuTaoTiZi() {
        return puTaoTiZi;
    }

    public void setPuTaoTiZi(ArrayList<ProductBean> puTaoTiZi) {
        this.puTaoTiZi = puTaoTiZi;
    }

    public ArrayList<ProductBean> getQiYiGuo() {
        return qiYiGuo;
    }

    public void setQiYiGuo(ArrayList<ProductBean> qiYiGuo) {
        this.qiYiGuo = qiYiGuo;
    }

    public ArrayList<ProductBean> getGanJuChengYou() {
        return ganJuChengYou;
    }

    public void setGanJuChengYou(ArrayList<ProductBean> ganJuChengYou) {
        this.ganJuChengYou = ganJuChengYou;
    }

    public ArrayList<ProductBean> getNiuYouGuo() {
        return niuYouGuo;
    }

    public void setNiuYouGuo(ArrayList<ProductBean> niuYouGuo) {
        this.niuYouGuo = niuYouGuo;
    }

    public ArrayList<ProductBean> getShiLingShuiGuo() {
        return shiLingShuiGuo;
    }

    public void setShiLingShuiGuo(ArrayList<ProductBean> shiLingShuiGuo) {
        this.shiLingShuiGuo = shiLingShuiGuo;
    }

    public ArrayList<ProductBean> getReDaiShuiGuo() {
        return reDaiShuiGuo;
    }

    public void setReDaiShuiGuo(ArrayList<ProductBean> reDaiShuiGuo) {
        this.reDaiShuiGuo = reDaiShuiGuo;
    }

    public ArrayList<ProductBean> getYeZi() {
        return yeZi;
    }

    public void setYeZi(ArrayList<ProductBean> yeZi) {
        this.yeZi = yeZi;
    }

    public ArrayList<ProductBean> getXiangJiao() {
        return xiangJiao;
    }

    public void setXiangJiao(ArrayList<ProductBean> xiangJiao) {
        this.xiangJiao = xiangJiao;
    }

    public ArrayList<ProductBean> getPingGuoLi() {
        return pingGuoLi;
    }

    public void setPingGuoLi(ArrayList<ProductBean> pingGuoLi) {
        this.pingGuoLi = pingGuoLi;
    }

    public ArrayList<ProductBean> getYeQing() {
        return yeQing;
    }

    public void setYeQing(ArrayList<ProductBean> yeQing) {
        this.yeQing = yeQing;
    }
}
