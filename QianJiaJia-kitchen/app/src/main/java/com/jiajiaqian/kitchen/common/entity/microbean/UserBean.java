package com.jiajiaqian.kitchen.common.entity.microbean;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-08 22:11
 * @Description 用户对应字段
 */
public class UserBean implements Serializable {

    private String userName;

    private String nickname;

    private int age;

    private String sex;

    private String img;

    private String email;

    private String phone;

    private String qq;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}