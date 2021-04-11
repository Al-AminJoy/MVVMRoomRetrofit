package com.alamin.mvvm_room_retrofit.network;

import com.alamin.mvvm_room_retrofit.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/data.php")
    Call<List<Posts>> getPosts();
}
