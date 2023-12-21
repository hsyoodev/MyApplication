package com.example.myapplication;

public class Product {
    int icon;
    String title;
    String url;

    public Product(int icon, String title, String url) {
        this.icon = icon;
        this.title = title;
        this.url = url;
    }

    public Product() {
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
