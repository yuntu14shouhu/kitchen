package com.jiajiaqian.kitchen.common.entity;

import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 商品详情查看
 * @Date 2017-04-14 15:09
 * @email qianjiajia_2013@126.com
 */
public class ProductDetailsQueryBean implements Serializable {


    /**
     * code : SUCCESS
     * message : null
     * data : {"id":"914700b55d714ce798a26fef0c0888bd","putawayDate":1489396900657,"kinds":"string","productName":"面筋","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/48052850-file_1489395761502_17201.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489376661476,"price":4.4,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489376661476,"endDate":1489376661476,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489376661476,"endGroupBuyDate":1489376661476,"keyClass":"豆制品","bigKeyClass":"蔬菜","keyword":"string"}
     * fieldErrors : {}
     */

    private String code;
    private Object message;
    private ProductBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public ProductBean getData() {
        return data;
    }

    public void setData(ProductBean data) {
        this.data = data;
    }

}