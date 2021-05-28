package com.alamin.mvvm_room_retrofit.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.alamin.mvvm_room_retrofit.service.model.Post;
import com.alamin.mvvm_room_retrofit.service.repository.MainActivityRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MainActivityRepository mainActivityRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mainActivityRepository =new MainActivityRepository(application);
    }

    public void insert(List<Post> posts){
        mainActivityRepository.insert(posts);
    }

    public LiveData<List<Post>> getAllPosts()
    {
        return mainActivityRepository.getAllPosts();
    }
    public MutableLiveData<List<Post>> getPostFromServer(){
        return mainActivityRepository.getPostFromServer();
    }

}
