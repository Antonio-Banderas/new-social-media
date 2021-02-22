package com.example.demo.services;

import com.example.demo.models.Post;

import java.util.ArrayList;


public class PostAnalysisService {

    ArrayList<Post>     allPostsAsPost;
    ArrayList<String>   allPostsAsString;

    public PostAnalysisService(){
        this.allPostsAsPost     = new ArrayList<>();
        this.allPostsAsString   = new ArrayList<>();
    }

    public void addPost(Post p){
        allPostsAsPost.add(p);
        allPostsAsString.add(p.toString());
    }

    public ArrayList<Post> getAllPostsAsPost() {
        return allPostsAsPost;
    }

    public ArrayList<String> getAllPostsAsString() {
        return allPostsAsString;
    }
}
