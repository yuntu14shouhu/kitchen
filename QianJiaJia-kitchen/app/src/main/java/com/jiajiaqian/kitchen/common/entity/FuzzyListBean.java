package com.jiajiaqian.kitchen.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 模糊查询list
 * @Date 2017-04-13 14:34
 * @email qianjiajia_2013@126.com
 */
public class FuzzyListBean implements Serializable {

    /**
     * code : SUCCESS
     * message : null
     * data : [{"id":"ef9907621b0f47b8abb65d506329bf9a","putawayDate":1489396759888,"kinds":"string","productName":"大豆腐","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/95294334-file_1489395761269_e6d6.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489376661476,"price":1.4,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489376661476,"endDate":1489376661476,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489376661476,"endGroupBuyDate":1489376661476,"keyClass":"豆制品","bigKeyClass":"蔬菜","keyword":"string"},{"id":"b740afa6fac846cda8817f9c3b14ee43","putawayDate":1489396927601,"kinds":"string","productName":"大葱","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/75863630-file_1489395771056_e7c.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489376661476,"price":2.4,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489376661476,"endDate":1489376661476,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489376661476,"endGroupBuyDate":1489376661476,"keyClass":"根茎类","bigKeyClass":"蔬菜","keyword":"string"},{"id":"6f9027f3ee9c445399ba5dfd78e566be","putawayDate":1489398132963,"kinds":"string","productName":"大白菜","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/27372399-file_1489395809003_70a8.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489376661476,"price":1.2,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489376661476,"endDate":1489376661476,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489376661476,"endGroupBuyDate":1489376661476,"keyClass":"叶菜类","bigKeyClass":"蔬菜","keyword":"string"},{"id":"609782041cec472cb1e16129ebf09f85","putawayDate":1489455630882,"kinds":"string","productName":"大豆油","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-13/69240079-file_1489420719415_e71a.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":48,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"食用油","bigKeyClass":"粮油副食","keyword":"string"},{"id":"b7b1e90510454162b7d45b3b3071b35f","putawayDate":1489459804432,"kinds":"string","productName":"大草虾","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/67838940-file_1489421260833_211e.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":48.7,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"虾蟹类","bigKeyClass":"水产","keyword":"string"},{"id":"4c0f8cf8835e48968715f7fec6df1e03","putawayDate":1489459835933,"kinds":"string","productName":"大闸蟹","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/41899456-file_1489421260962_5a89.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489454726124,"price":68.7,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489454726124,"endDate":1489454726124,"carriage":8,"isGroupBuy":0,"groupBuyPrice":0,"groupBuyPersonNumber":0,"startGroupBuyDate":1489454726124,"endGroupBuyDate":1489454726124,"keyClass":"虾蟹类","bigKeyClass":"水产","keyword":"string"},{"id":"d16c29be5b094c6d907f54941f0c18a4","putawayDate":1489470101974,"kinds":"string","productName":"大螃蟹","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/38444784-file_1489469241121_3d43.png","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489460880552,"price":20,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489460880552,"endDate":1489460880552,"carriage":8,"isGroupBuy":1,"groupBuyPrice":18.8,"groupBuyPersonNumber":3,"startGroupBuyDate":1489460880552,"endGroupBuyDate":1489979280000,"keyClass":"string","bigKeyClass":"string","keyword":"string"},{"id":"57ffccf21b194386ba84a1f3c3a565bb","putawayDate":1489470417427,"kinds":"string","productName":"新疆和田大枣","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/14915854-file_1489469240853_13041.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489460880552,"price":66.6,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489460880552,"endDate":1489460880552,"carriage":8,"isGroupBuy":1,"groupBuyPrice":62.2,"groupBuyPersonNumber":4,"startGroupBuyDate":1489460880552,"endGroupBuyDate":1490238480000,"keyClass":"string","bigKeyClass":"string","keyword":"string"},{"id":"f895245e348d419e8b761f5db42a9772","putawayDate":1489470469875,"kinds":"string","productName":"大甜椒","productImageUrl":"http://omkwzwj7w.bkt.clouddn.com/17-3-14/66196202-file_1489469240592_a650.jpg","status":0,"productTypes":"string","producer":"string","address":"string","described":"string","productionDate":1489460880552,"price":8.89,"discountPrice":0,"isDiscount":0,"limitNumber":1,"kindNumber":0,"startDate":1489460880552,"endDate":1489460880552,"carriage":8,"isGroupBuy":1,"groupBuyPrice":8.2,"groupBuyPersonNumber":2,"startGroupBuyDate":1489460880552,"endGroupBuyDate":1490411280000,"keyClass":"string","bigKeyClass":"string","keyword":"string"}]
     * fieldErrors : {}
     */

    private String code;
    private Object message;
    private FieldErrorsBean fieldErrors;
    private List<DataBean> data;

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

    public FieldErrorsBean getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(FieldErrorsBean fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class FieldErrorsBean {
    }

    public static class DataBean {
        /**
         * id : ef9907621b0f47b8abb65d506329bf9a
         * putawayDate : 1489396759888
         * kinds : string
         * productName : 大豆腐
         * productImageUrl : http://omkwzwj7w.bkt.clouddn.com/17-3-13/95294334-file_1489395761269_e6d6.jpg
         * status : 0
         * productTypes : string
         * producer : string
         * address : string
         * described : string
         * productionDate : 1489376661476
         * price : 1.4
         * discountPrice : 0
         * isDiscount : 0
         * limitNumber : 1
         * kindNumber : 0
         * startDate : 1489376661476
         * endDate : 1489376661476
         * carriage : 8
         * isGroupBuy : 0
         * groupBuyPrice : 0
         * groupBuyPersonNumber : 0
         * startGroupBuyDate : 1489376661476
         * endGroupBuyDate : 1489376661476
         * keyClass : 豆制品
         * bigKeyClass : 蔬菜
         * keyword : string
         */

        private String id;
        private long putawayDate;
        private String kinds;
        private String productName;
        private String productImageUrl;
        private int status;
        private String productTypes;
        private String producer;
        private String address;
        private String described;
        private long productionDate;
        private double price;
        private double discountPrice;
        private int isDiscount;
        private int limitNumber;
        private int kindNumber;
        private long startDate;
        private long endDate;
        private int carriage;
        private int isGroupBuy;
        private double groupBuyPrice;
        private int groupBuyPersonNumber;
        private long startGroupBuyDate;
        private long endGroupBuyDate;
        private String keyClass;
        private String bigKeyClass;
        private String keyword;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getPutawayDate() {
            return putawayDate;
        }

        public void setPutawayDate(long putawayDate) {
            this.putawayDate = putawayDate;
        }

        public String getKinds() {
            return kinds;
        }

        public void setKinds(String kinds) {
            this.kinds = kinds;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductImageUrl() {
            return productImageUrl;
        }

        public void setProductImageUrl(String productImageUrl) {
            this.productImageUrl = productImageUrl;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getProductTypes() {
            return productTypes;
        }

        public void setProductTypes(String productTypes) {
            this.productTypes = productTypes;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDescribed() {
            return described;
        }

        public void setDescribed(String described) {
            this.described = described;
        }

        public long getProductionDate() {
            return productionDate;
        }

        public void setProductionDate(long productionDate) {
            this.productionDate = productionDate;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(double discountPrice) {
            this.discountPrice = discountPrice;
        }

        public int getIsDiscount() {
            return isDiscount;
        }

        public void setIsDiscount(int isDiscount) {
            this.isDiscount = isDiscount;
        }

        public int getLimitNumber() {
            return limitNumber;
        }

        public void setLimitNumber(int limitNumber) {
            this.limitNumber = limitNumber;
        }

        public int getKindNumber() {
            return kindNumber;
        }

        public void setKindNumber(int kindNumber) {
            this.kindNumber = kindNumber;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public int getCarriage() {
            return carriage;
        }

        public void setCarriage(int carriage) {
            this.carriage = carriage;
        }

        public int getIsGroupBuy() {
            return isGroupBuy;
        }

        public void setIsGroupBuy(int isGroupBuy) {
            this.isGroupBuy = isGroupBuy;
        }

        public double getGroupBuyPrice() {
            return groupBuyPrice;
        }

        public void setGroupBuyPrice(double groupBuyPrice) {
            this.groupBuyPrice = groupBuyPrice;
        }

        public int getGroupBuyPersonNumber() {
            return groupBuyPersonNumber;
        }

        public void setGroupBuyPersonNumber(int groupBuyPersonNumber) {
            this.groupBuyPersonNumber = groupBuyPersonNumber;
        }

        public long getStartGroupBuyDate() {
            return startGroupBuyDate;
        }

        public void setStartGroupBuyDate(long startGroupBuyDate) {
            this.startGroupBuyDate = startGroupBuyDate;
        }

        public long getEndGroupBuyDate() {
            return endGroupBuyDate;
        }

        public void setEndGroupBuyDate(long endGroupBuyDate) {
            this.endGroupBuyDate = endGroupBuyDate;
        }

        public String getKeyClass() {
            return keyClass;
        }

        public void setKeyClass(String keyClass) {
            this.keyClass = keyClass;
        }

        public String getBigKeyClass() {
            return bigKeyClass;
        }

        public void setBigKeyClass(String bigKeyClass) {
            this.bigKeyClass = bigKeyClass;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
    }
}