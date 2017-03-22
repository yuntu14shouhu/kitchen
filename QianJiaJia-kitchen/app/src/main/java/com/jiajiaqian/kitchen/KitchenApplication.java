package com.jiajiaqian.kitchen;

import android.app.Application;

import com.jiajiaqian.kitchen.common.network.NetRequestManager;

import org.xutils.x;

/**
 * Created by t_xuz on 12/13/16.
 */

public class KitchenApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        //初始化网络请求队列
        NetRequestManager.getInstance().init(this);
    }
}
