package com.jiajiaqian.kitchen.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/4/6.
 * 用户信息sp管理类
 */

public final class UserInfoUtils {

    private static final String USER_INFO = "user_info";

    public static String getUserId(Context context){
        SharedPreferences sp = context.getSharedPreferences(USER_INFO,Context.MODE_PRIVATE);
        String userId = sp.getString("user_id",null);
        if (userId != null){
            return userId;
        }
        return null;
    }

    public static String getUserName(Context context){
        SharedPreferences sp = context.getSharedPreferences(USER_INFO,Context.MODE_PRIVATE);
        String user_name = sp.getString("user_name",null);
        if (user_name != null){
            return user_name;
        }
        return null;
    }

    public static String getDefaultAddress(Context context){
        SharedPreferences sp = context.getSharedPreferences(USER_INFO,Context.MODE_PRIVATE);
        String address = sp.getString("default_address",null);
        if (address != null){
            return address;
        }
        return null;
    }

    public  static void clearLoginCache(Context context){
        SharedPreferences sp = context.getSharedPreferences(USER_INFO,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }
}
