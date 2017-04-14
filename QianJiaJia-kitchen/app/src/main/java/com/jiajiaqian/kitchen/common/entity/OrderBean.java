package com.jiajiaqian.kitchen.common.entity;

import com.jiajiaqian.kitchen.common.entity.microbean.ProductBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 订单bean
 * @Date 2017-03-17 14:40
 * @email qianjiajia_2013@126.com
 */
public class OrderBean implements Serializable {
//
    /**
     * date : 1491467597090
     * total : 55
     * product : [{"id":"e5c31a2486a54ff5bf82c2c29a1fb7a4","putawayDate":1489458778077,"kinds":"string","productName":"牛腩块","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/21189348-file_1489421103363_17999.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":48.4,"discountPrice":0,"isDiscount":0,"limitNumber":0,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"牛肉","bigKeyClass":"肉类","keyword":"string"},{"id":"504ae486982b46e991bf6c975deca446","putawayDate":1489458853353,"kinds":"string","productName":"牛肉粒","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/75629652-file_1489458836689_4ae3.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":68.4,"discountPrice":0,"isDiscount":0,"limitNumber":0,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"牛肉","bigKeyClass":"肉类","keyword":"string"},{"id":"38aaecba6d2b4ca09be68b637670177c","putawayDate":1489458873145,"kinds":"string","productName":"牛肉片","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/67589489-file_1489421103800_101ea.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":48.4,"discountPrice":0,"isDiscount":0,"limitNumber":0,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"牛肉","bigKeyClass":"肉类","keyword":"string"}]
     * id : f94300622c57487c98c51deb3fe1d4b5
     */

    private long date;
    private double total;
    private String id;
    private ArrayList<ProductBean> product;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<ProductBean> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<ProductBean> product) {
        this.product = product;
    }

}