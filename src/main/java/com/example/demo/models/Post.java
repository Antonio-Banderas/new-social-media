package com.example.demo.models;

public class Post {

    private String title;
    private int price;

    public Post(String title, int price) {

        this.title = title;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
