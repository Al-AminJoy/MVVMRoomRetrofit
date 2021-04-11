package com.alamin.mvvm_room_retrofit.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alamin.mvvm_room_retrofit.model.Posts;

import java.util.List;

@Dao
public interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Posts> posts);

    @Query("SELECT DISTINCT * FROM post")
    LiveData<List<Posts>> getAllPosts();

    @Query("DELETE FROM post")
    void deleteAll();
}
