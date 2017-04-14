package com.jiajiaqian.kitchen.common.entity.microbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/20.
 */

public class FoodBean implements Serializable{

    @SerializedName("shi_yong_you")
    private ArrayList<ProductBean> shiYongYou;
    @SerializedName("tiao_wei_fen_lei")
    private ArrayList<ProductBean> tiaoWeiFenLei;
    @SerializedName("tiao_wei_jiang_lei")
    private ArrayList<ProductBean> tiaoWeiJiangLei;
    @SerializedName("mi_mian_za_liang")
    private ArrayList<ProductBean> miMianZaLiang;
    @SerializedName("nan_bei_gan_huo")
    private ArrayList<ProductBean> nanBeiGanHuo;

    public ArrayList<ProductBean> getShiYongYou() {
        return shiYongYou;
    }

    public void setShiYongYou(ArrayList<ProductBean> shiYongYou) {
        this.shiYongYou = shiYongYou;
    }

    public ArrayList<ProductBean> getTiaoWeiFenLei() {
        return tiaoWeiFenLei;
    }

    public void setTiaoWeiFenLei(ArrayList<ProductBean> tiaoWeiFenLei) {
        this.tiaoWeiFenLei = tiaoWeiFenLei;
    }

    public ArrayList<ProductBean> getTiaoWeiJiangLei() {
        return tiaoWeiJiangLei;
    }

    public void setTiaoWeiJiangLei(ArrayList<ProductBean> tiaoWeiJiangLei) {
        this.tiaoWeiJiangLei = tiaoWeiJiangLei;
    }

    public ArrayList<ProductBean> getMiMianZaLiang() {
        return miMianZaLiang;
    }

    public void setMiMianZaLiang(ArrayList<ProductBean> miMianZaLiang) {
        this.miMianZaLiang = miMianZaLiang;
    }

    public ArrayList<ProductBean> getNanBeiGanHuo() {
        return nanBeiGanHuo;
    }

    public void setNanBeiGanHuo(ArrayList<ProductBean> nanBeiGanHuo) {
        this.nanBeiGanHuo = nanBeiGanHuo;
    }
}
