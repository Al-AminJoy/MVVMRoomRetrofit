package com.alamin.mvvm_room_retrofit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.alamin.mvvm_room_retrofit.model.Posts;
import com.alamin.mvvm_room_retrofit.repository.Repository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
    private Repository repository;
    public LiveData<List<Posts>> getAllPosts;

    public PostViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        getAllPosts=repository.getAllPosts();
    }

    public void insert(List<Posts> posts){
        repository.insert(posts);
    }

    public LiveData<List<Posts>> getAllPosts()
    {
        return getAllPosts;
    }
}
