package com.jiajiaqian.kitchen.common.entity.microbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jasonxu on 2017/3/20.
 */

public class FishBean implements Serializable{

    @SerializedName("dan_shui_yu")
    private ArrayList<ProductBean> danShuiYu;
    @SerializedName("xia_xie_lei")
    private ArrayList<ProductBean> xiaXieLei;
    @SerializedName("hai_shui_yu")
    private ArrayList<ProductBean> haiShuiYu;
    @SerializedName("bei_ke_lei")
    private ArrayList<ProductBean> beiKeLei;

    public ArrayList<ProductBean> getDanShuiYu() {
        return danShuiYu;
    }

    public void setDanShuiYu(ArrayList<ProductBean> danShuiYu) {
        this.danShuiYu = danShuiYu;
    }

    public ArrayList<ProductBean> getXiaXieLei() {
        return xiaXieLei;
    }

    public void setXiaXieLei(ArrayList<ProductBean> xiaXieLei) {
        this.xiaXieLei = xiaXieLei;
    }

    public ArrayList<ProductBean> getHaiShuiYu() {
        return haiShuiYu;
    }

    public void setHaiShuiYu(ArrayList<ProductBean> haiShuiYu) {
        this.haiShuiYu = haiShuiYu;
    }

    public ArrayList<ProductBean> getBeiKeLei() {
        return beiKeLei;
    }

    public void setBeiKeLei(ArrayList<ProductBean> beiKeLei) {
        this.beiKeLei = beiKeLei;
    }
}
