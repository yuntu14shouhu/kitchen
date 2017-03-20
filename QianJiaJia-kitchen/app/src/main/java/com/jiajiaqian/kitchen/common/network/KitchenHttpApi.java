package com.jiajiaqian.kitchen.common.network;

import android.support.annotation.NonNull;

/**
 * Created by jasonxu on 2017/3/11.
 */

public interface KitchenHttpApi<T> {

    void getHomeData(@NonNull String uid,@NonNull T callback);

    void getYouHuiLists(@NonNull T callback);

    void getRenQiLists(@NonNull T callback);

    void getJinBaoLists(@NonNull T callback);

    void getSortData(@NonNull String uid,@NonNull T callback);

}
