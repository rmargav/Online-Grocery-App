package com.example.onlinegrocerymargav;

public class Grocery
{
    String gid;
    String imgUrl;
    String name;
    int price;
    int stock;
    String unit;

    public Grocery()
    {
    }

    public Grocery(String gid, String imgUrl, String name, int price, int stock, String unit) {
        this.gid = gid;
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.unit = unit;
    }

    public String toString()
    {
        return "NAME = "+name+" , PRICE = "+price+" STOCK = "+stock;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
