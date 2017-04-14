package com.jiajiaqian.kitchen.common.entity;

import com.jiajiaqian.kitchen.common.entity.microbean.EggBean;
import com.jiajiaqian.kitchen.common.entity.microbean.FishBean;
import com.jiajiaqian.kitchen.common.entity.microbean.FoodBean;
import com.jiajiaqian.kitchen.common.entity.microbean.FruitBean;
import com.jiajiaqian.kitchen.common.entity.microbean.MeatBean;
import com.jiajiaqian.kitchen.common.entity.microbean.VegetableBean;

import java.io.Serializable;

/**
 * @author qianjiajia
 * @version 1.0
 * 2017/3/20.
 */

public class SortBean implements Serializable{

    private EggBean egg;
    private FruitBean fruit;
    private FishBean fish;
    private MeatBean meat;
    private VegetableBean vegetable;
    private FoodBean food;

    public EggBean getEgg() {
        return egg;
    }

    public void setEgg(EggBean egg) {
        this.egg = egg;
    }

    public FruitBean getFruit() {
        return fruit;
    }

    public void setFruit(FruitBean fruit) {
        this.fruit = fruit;
    }

    public FishBean getFish() {
        return fish;
    }

    public void setFish(FishBean fish) {
        this.fish = fish;
    }

    public MeatBean getMeat() {
        return meat;
    }

    public void setMeat(MeatBean meat) {
        this.meat = meat;
    }

    public VegetableBean getVegetable() {
        return vegetable;
    }

    public void setVegetable(VegetableBean vegetable) {
        this.vegetable = vegetable;
    }

    public FoodBean getFood() {
        return food;
    }

    public void setFood(FoodBean food) {
        this.food = food;
    }
}
