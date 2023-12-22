package com.example.myapplication;

public class ShopVO {
    int shopImg;
    String shopName;
    String shopDesc;

    public ShopVO(int shopImg, String shopName, String shopDesc) {
        this.shopImg = shopImg;
        this.shopName = shopName;
        this.shopDesc = shopDesc;
    }

    public int getShopImg() {
        return shopImg;
    }

    public void setShopImg(int shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }
}
