package com.jiajiaqian.kitchen.common.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.Request;
import com.jiajiaqian.kitchen.common.appglobal.ApiConstants;

import org.json.JSONObject;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/11.
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

    //http://localhost:8080/address/delete?addressId=
    @Override
    public void deleteAddress(@NonNull String uid, @NonNull String addressId, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/address/delete?addressId=" + addressId;
        get(requestUrl,callback);
    }

    //http://localhost:8080/address/update
    @Override
    public void updateAddress(@NonNull String addressId, @NonNull JSONObject jsonRequest, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/address/update";
        post(requestUrl,jsonRequest,callback);
    }

    //http://localhost:8080/address/save
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

    //http://localhost:8080/search/aaqueryHot
    @Override
    public void getHotSearchList(@NonNull String keyWord, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/search/aaqueryHot";
        get(requestUrl,callback);
    }

   // http://localhost:8080/search/aaqueryHistory?userId=a240611ed1174b4dbf3d6536517d3b6c
    @Override
    public void getHistorySearchList(@NonNull String uid, @NonNull String keyWord, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/search/aaqueryHistory?userId=" + uid;
        get(requestUrl,callback);
    }

    //http://localhost:8080/search/deleteAll?userId=a240611ed1174b4dbf3d6536517d3b6c
    @Override
    public void getDeleteAllSearchList(@NonNull String uid, @NonNull String keyWord, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/search/deleteAll?userId=" + uid;
        get(requestUrl,callback);
    }

    //http://localhost:8080/address/queryDetails?addressId=
    @Override
    public void getAddressDetails(@NonNull String addressId, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/address/queryDetails?addressId=" + addressId;
        get(requestUrl,callback);
    }

    //http://localhost:8080/product/fuzzyQuery?productName=%E7%B1%B3
    @Override
    public void getFuzzy(@NonNull String productName, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/fuzzyQuery?productName=" +productName;
        get(requestUrl,callback);
    }

    //http://localhost:8080/search/save
    @Override
    public void saveSearchContent(@NonNull String uid, @NonNull JSONObject jsonObject, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/search/save";
        post(requestUrl,jsonObject,callback);
    }

    //http://localhost:8080/product/getById?productId=914700b55d714ce798a26fef0c0888bd
    @Override
    public void getProductDetails(@NonNull String productId, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/product/getById?productId=" + productId;
        get(requestUrl,callback);
    }

    //http://localhost:8080/shoppingCart/queryShop
    @Override
    public void getShopList(@NonNull OkJsonRequest.OKResponseCallback callback) {
       String requestUrl = ApiConstants.BASE_URL + "/shoppingCart/queryShop" ;
        get(requestUrl,callback);
    }

    //http://localhost:8080/shoppingCart/saveShop
    @Override
    public void addProductToShop(@NonNull String productId, @NonNull JSONObject jsonObject, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/shoppingCart/saveShop";
        post(requestUrl,jsonObject,callback);
    }

    //http://localhost:8080/orderDetailsModify/submitOrder
    @Override
    public void submitOrder(@NonNull String orderId, @NonNull String addressId, @NonNull JSONObject jsonObject, @NonNull OkJsonRequest.OKResponseCallback callback) {
        String requestUrl = ApiConstants.BASE_URL + "/orderDetailsModify/submitOrder";
        post(requestUrl,jsonObject,callback);
    }

}
