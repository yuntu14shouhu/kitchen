package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jasonxu on 2017/4/5.
 */

public class AddressListBean implements Serializable{

    private String code;
    private String message;
    private ArrayList<AddressBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<AddressBean> getData() {
        return data;
    }

    public void setData(ArrayList<AddressBean> data) {
        this.data = data;
    }
}
