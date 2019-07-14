package com.sdust.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by Cierlly on 7/13/2019.
 */
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ShopListVo {
    private String shopid;
    private String shopperid;
    private String fruitid;
    private Integer num;
    private String state;
    private Shopper shopper;
    private Commodities commodities;

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getShopperid() {
        return shopperid;
    }

    public void setShopperid(String shopperid) {
        this.shopperid = shopperid;
    }

    public String getFruitid() {
        return fruitid;
    }

    public void setFruitid(String fruitid) {
        this.fruitid = fruitid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public Commodities getCommodities() {
        return commodities;
    }

    public void setCommodities(Commodities commodities) {
        this.commodities = commodities;
    }
}
