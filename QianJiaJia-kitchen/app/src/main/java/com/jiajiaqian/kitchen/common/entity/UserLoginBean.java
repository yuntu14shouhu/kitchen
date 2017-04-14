package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/6.
 */

public class UserLoginBean implements Serializable{

    private String code;
    private String message;
    private UserBean data;

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

    public UserBean getData() {
        return data;
    }

    public void setData(UserBean data) {
        this.data = data;
    }
}
