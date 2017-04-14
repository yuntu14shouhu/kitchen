package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;

/**
 *@author qianjiajia
 * @version 1.0
 * 2017/4/6.
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

    /**
     * 2017-04-07--16:00:00修改为-----------------
     *
     * id : a240611ed1174b4dbf3d6536517d3b6c
     * userName : string46
     * password : 60df882a80f5c8bca08b3aeb0025fb561daa65bdcadb38dd4ea2376a3fd43f5934aa956453598cb23b83965adee87a7d4163d6d8989b52c57cef07befc021116
     * nickName : string
     * salt : kitchen
     * status : 0
     * sex : string
     * age : 0
     * createTime : 1491471599552
     * remark : string
     * email : string
     * phone : string111
     * qqnumber : string
     */

    private String id;
    private String userName;
    private String password;
    private String nickName;
    private String salt;
    private int status;
    private String sex;
    private int age;
    private long createTime;
    private String remark;
    private String email;
    private String phone;
    private String qqnumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", qqnumber='" + qqnumber + '\'' +
                '}';
    }
}
