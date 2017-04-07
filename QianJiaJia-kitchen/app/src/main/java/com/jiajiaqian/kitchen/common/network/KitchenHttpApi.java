package com.jiajiaqian.kitchen.common.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.json.JSONObject;

/**
 * Created by jasonxu on 2017/3/11.
 */

public interface KitchenHttpApi<T> {

    void getHomeData(@NonNull String uid,@NonNull T callback);

    void getYouHuiLists(@NonNull T callback);

    void getRenQiLists(@NonNull T callback);

    void getJinBaoLists(@NonNull T callback);

    void getSortData(@NonNull String uid,@NonNull T callback);

    void getAddressLists(@NonNull String uid,@NonNull T callback);

    void deleteAddress(@NonNull String uid,@NonNull String addressId,@NonNull T callback);

    void updateAddress(@NonNull String uid,@NonNull String addressId,@NonNull T callback);

    void addAddress(@NonNull String uid, @NonNull JSONObject jsonRequest, @NonNull T callback);

    void userLogin(@NonNull String userName,@NonNull String userPassword,@NonNull T callback);

    void orderList(@NonNull String uid, @Nullable T callback);

    void orderDetail(@NonNull String orderId,@NonNull T callback);

    void userData(@NonNull String uid, @Nullable T callback);

    void userDataUpdate(@NonNull String uid,@NonNull JSONObject jsonRequest,@NonNull T callback);

    void userSave(@NonNull String uid,@NonNull JSONObject jsonRequest,@NonNull T callback);

}
