package com.jiajiaqian.kitchen;

import android.app.Application;

import com.jiajiaqian.kitchen.common.network.NetRequestManager;

import org.xutils.x;

/**
 *  @author qianjiajia
 * @version 1.0
 */

public class KitchenApplication extends Application {

    public static int mShopNum; //记录整个应用的商品添加的数量，全局变量

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        //初始化网络请求队列
        NetRequestManager.getInstance().init(this);
    }
}
