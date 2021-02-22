package com.example.demo.models;

public class Post {

    private String title;
    private int price;

    public Post(String title, int price) {

        this.title = title;
        this.price = price;

    }

    @Override
    public String toString() {
        return "[ Title: " + title + "Price: " + price + " ]";
    }
}
