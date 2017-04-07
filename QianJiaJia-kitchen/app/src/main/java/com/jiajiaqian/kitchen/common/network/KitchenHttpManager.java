package com.jiajiaqian.kitchen.common.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.Request;
import com.jiajiaqian.kitchen.common.appglobal.ApiConstants;

import org.json.JSONObject;

/**
 * Created by jasonxu on 2017/3/11.
 */

public class KitchenHttpManager implements KitchenHttpApi<OkJsonRequest.OKResponseCallback> {

    private KitchenHttpManager() {
    }

    private static class KitchenHttpManagerHolder {
        private static final KitchenHttpManager INSTANCE = new KitchenHttpManager();
    }

    public static KitchenHttpManager getInstance() {
        return KitchenHttpManagerHolder.INSTANCE;
    }

    //http://192.168.0.110:8080/product/aaaapage
    @Override
    public void getHomeData(@NonNull String uid, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/aaaapage";
        get(requestUrl, callback);
    }

    //http://192.168.0.110:8080/product/productIsDiscount?isDiscount=1
    @Override
    public void getYouHuiLists(@NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/productIsDiscount?isDiscount=1";
        get(requestUrl, callback);
    }

    @Override
    public void getRenQiLists(@NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/productByPutawayDate";
        get(requestUrl, callback);
    }

    @Override
    public void getJinBaoLists(@NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/productIsGroup?isGroupBuy=1";
        get(requestUrl, callback);
    }

    //http://192.168.0.110:8080/product/classifydatas
    @Override
    public void getSortData(@NonNull String uid, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/classifydatas";
        get(requestUrl, callback);
    }

    @Override
    public void getAddressLists(@NonNull String uid, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/address/queryAll";
        get(requestUrl, callback);
    }

    @Override
    public void deleteAddress(@NonNull String uid, @NonNull String addressId, @NonNull OkJsonRequest.OKResponseCallback callback) {

    }

    @Override
    public void updateAddress(@NonNull String uid, @NonNull String addressId, @NonNull OkJsonRequest.OKResponseCallback callback) {

    }

    @Override
    public void addAddress(@NonNull String uid, @NonNull JSONObject jsonRequest, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/address/save";
        post(requestUrl, jsonRequest, callback);
    }

    //http://192.168.0.110:8080/user/query?username=zhangsan
    @Override
    public void userLogin(@NonNull String userName, @NonNull String userPassword, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/user/login";
        JSONObject jsonRequest = new JSONObject();
        try {
            jsonRequest.put("userName", userName);
            jsonRequest.put("password", userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        post(requestUrl, jsonRequest, callback);
    }

    private void get(String requestUrl, @NonNull OkJsonRequest.OKResponseCallback callback) {
        OkJsonRequest okRequest = new OkJsonRequest(OkJsonRequest.Method.GET, requestUrl, null, callback);
        NetRequestManager.getInstance().addRequest(okRequest);
    }

    private void post(String requestUrl, JSONObject jsonRequest, @NonNull OkJsonRequest.OKResponseCallback callback) {
        OkJsonRequest okRequest = new OkJsonRequest(Request.Method.POST, requestUrl, jsonRequest, callback);
        NetRequestManager.getInstance().addRequest(okRequest);
    }


    //http://localhost:8080/orderDetailsModify/queryOrders?userId=a240611ed1174b4dbf3d6536517d3b6c
    @Override
    public void orderList(@NonNull String uid, @Nullable OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/orderDetailsModify/queryOrders";
        get(requestUrl, callback);
    }

    //    http://localhost:8080/orderDetailsModify/query?orderId=e654298fce4e42b5965723bdea701313
    @Override
    public void orderDetail(@NonNull String orderId, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/orderDetailsModify/query?orderId=" + orderId;
        get(requestUrl, callback);
    }

    //    http://localhost:8080/user/queryByUserId?userId=a240611ed1174b4dbf3d6536517d3b6c
    @Override
    public void userData(@NonNull String uid, @Nullable OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/user/queryByUserId";
        get(requestUrl, callback);
    }

    //    http://localhost:8080/user/update
    @Override
    public void userDataUpdate(@NonNull String uid, @NonNull JSONObject jsonRequest, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/user/update";
        post(requestUrl, jsonRequest, callback);
    }

    //    http://localhost:8080/user/save
    @Override
    public void userSave(@NonNull String uid, @NonNull JSONObject jsonRequest, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/user/save";
        post(requestUrl, jsonRequest, callback);
    }

    //http://192.168.0.101:8080/product/popularitySearch?productName=%E5%93%88%E5%93%88
    @Override
    public void getHotSearchList(@NonNull String keyWord, @NonNull OkJsonRequest.OKResponseCallback callback) {

    }

    @Override
    public void getHistorySearchList(@NonNull String uid, @NonNull String keyWord, @NonNull OkJsonRequest.OKResponseCallback callback) {

    }

    @Override
    public void getAllSearchList(@NonNull String uid, @NonNull String keyWord, @NonNull OkJsonRequest.OKResponseCallback callback) {

    }
}
