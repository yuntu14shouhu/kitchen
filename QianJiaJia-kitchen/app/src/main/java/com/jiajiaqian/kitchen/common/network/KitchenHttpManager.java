package com.jiajiaqian.kitchen.common.network;

import android.support.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.jiajiaqian.kitchen.common.appglobal.ApiConstants;
import com.jiajiaqian.kitchen.common.entity.AddressBean;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        String requestUrl = ApiConstants.BASE_URL + "/address/quertAll";
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
        String requestUrl = ApiConstants.BASE_URL + "/user/query?username=" + userName;
        get(requestUrl,callback);
    }

    private void get(String requestUrl, @NonNull OkJsonRequest.OKResponseCallback callback) {
        OkJsonRequest okRequest = new OkJsonRequest(OkJsonRequest.Method.GET, requestUrl, null, callback);
        NetRequestManager.getInstance().addRequest(okRequest);
    }

    private void post(String requestUrl, JSONObject jsonRequest, @NonNull OkJsonRequest.OKResponseCallback callback) {
        OkJsonRequest okRequest = new OkJsonRequest(Request.Method.POST, requestUrl, jsonRequest, callback);
        NetRequestManager.getInstance().addRequest(okRequest);
    }
}
