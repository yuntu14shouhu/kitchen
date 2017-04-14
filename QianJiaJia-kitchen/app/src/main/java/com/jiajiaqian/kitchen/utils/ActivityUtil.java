package com.jiajiaqian.kitchen.utils;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

/**
 * @author qianjiajia
 * @version 1.0
 */
public final class ActivityUtil{

    /**
     * 根据自己的时间去定义一个Toast 输入时间为毫秒
     *
     * @param activity
     * @param message
     * @param time
     */
    public static void showToastBytTime(Activity activity, String message, int time) {
        final Toast toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                toast.cancel();
            }
        }, time);
    }
}