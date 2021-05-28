package com.alamin.mvvm_room_retrofit.service.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Posts {

    @SerializedName("post")
    @Expose
    private List<Post> post = null;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

}