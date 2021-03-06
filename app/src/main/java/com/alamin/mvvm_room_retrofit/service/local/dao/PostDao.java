package com.alamin.mvvm_room_retrofit.service.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alamin.mvvm_room_retrofit.service.model.Post;

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
