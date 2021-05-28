package com.alamin.mvvm_room_retrofit.service.network;

import com.alamin.mvvm_room_retrofit.service.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("b/ET8D")
    Call<Posts> getPosts();
}
