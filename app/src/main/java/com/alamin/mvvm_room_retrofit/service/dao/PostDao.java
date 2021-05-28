package com.alamin.mvvm_room_retrofit.service.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alamin.mvvm_room_retrofit.service.model.Post;
import com.alamin.mvvm_room_retrofit.service.model.Posts;

import java.util.List;

@Dao
public interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Post> Post);

    @Query("SELECT DISTINCT * FROM Post")
    LiveData<List<Post>> getAllPosts();

    @Query("DELETE FROM post")
    void deleteAll();
}
