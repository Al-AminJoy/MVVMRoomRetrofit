package com.alamin.mvvm_room_retrofit.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.alamin.mvvm_room_retrofit.dao.PostDao;
import com.alamin.mvvm_room_retrofit.database.PostDatabase;
import com.alamin.mvvm_room_retrofit.model.Posts;

import java.util.List;

public class Repository {

    public PostDao postDao;
    public LiveData<List<Posts>> getAllPosts;
    private PostDatabase database;


    public Repository(Application application){
        database=PostDatabase.getInstance(application);
        postDao=database.postDao();
        getAllPosts=postDao.getAllPosts();

    }

    public void insert(List<Posts> posts){

        new InsertAsyncTask(postDao).execute(posts);
    }

    public LiveData<List<Posts>> getAllPosts(){
        return getAllPosts;
    }


    private static class InsertAsyncTask extends AsyncTask<List<Posts>,Void,Void> {
        private PostDao postDao;

        public InsertAsyncTask(PostDao postDao)
        {
            this.postDao=postDao;
        }
        @Override
        protected Void doInBackground(List<Posts>... lists) {
            postDao.insert(lists[0]);
            return null;
        }
    }



}
