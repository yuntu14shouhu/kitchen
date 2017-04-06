package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 * Created by jasonxu on 2017/4/6.
 */

public class UserBean implements Serializable{

    /**
     * age : 0
     * contacts : string
     * createTime : 2017-04-06T06:20:34.915Z
     * id : string
     * nickName : string
     * password : string
     * remark : string
     * salt : string
     * sex : string
     * status : 0
     * userName : string
     */

    private int age;
    private String contacts;
    private String createTime;
    private String id;
    private String nickName;
    private String password;
    private String remark;
    private String salt;
    private String sex;
    private int status;
    private String userName;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
