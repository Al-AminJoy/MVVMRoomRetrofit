package com.alamin.mvvm_room_retrofit.service.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.alamin.mvvm_room_retrofit.service.local.dao.PostDao;
import com.alamin.mvvm_room_retrofit.service.local.database.PostDatabase;
import com.alamin.mvvm_room_retrofit.service.model.Post;
import com.alamin.mvvm_room_retrofit.service.model.Posts;
import com.alamin.mvvm_room_retrofit.service.network.APIClient;
import com.alamin.mvvm_room_retrofit.service.network.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityRepository {

    public PostDao postDao;
    public LiveData<List<Post>> getAllPosts;
    private PostDatabase database;
    public List<Post> postList;
    private MutableLiveData liveData;
    private Posts posts;


    public MainActivityRepository(Application application){
        database=PostDatabase.getInstance(application);
        postDao=database.postDao();
        getAllPosts=postDao.getAllPosts();

    }

    public void insert(List<Post> posts){

        new InsertAsyncTask(postDao).execute(posts);
    }
    private static class InsertAsyncTask extends AsyncTask<List<Post>,Void,Void> {
        private PostDao postDao;

        public InsertAsyncTask(PostDao postDao)
        {
            this.postDao=postDao;
        }
        @Override
        protected Void doInBackground(List<Post>... lists) {
            postDao.insert(lists[0]);
            return null;
        }
    }
    public LiveData<List<Post>> getAllPosts(){
        return getAllPosts;
    }

    public MutableLiveData<List<Post>> getPostFromServer(){
        if (liveData==null){
            liveData=new MutableLiveData();
        }
        Log.d("Call","I am called");
        APIService apiService= APIClient.getClient().create(APIService.class);
        Call<Posts> call=apiService.getPosts();
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                posts=response.body();
                Log.d("TAG1",response.body().toString());
                postList=posts.getPost();
                Log.d("TAG2",String.valueOf(postList.size()));
                Log.d("TAG","Name"+postList.get(0).getName());
                liveData.postValue(postList);
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {

            }
        });
        return liveData;
    }

}
