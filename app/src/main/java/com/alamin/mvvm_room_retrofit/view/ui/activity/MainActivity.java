package com.alamin.mvvm_room_retrofit.view.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.alamin.mvvm_room_retrofit.R;
import com.alamin.mvvm_room_retrofit.view.adapter.PostAdapter;
import com.alamin.mvvm_room_retrofit.service.model.Post;
import com.alamin.mvvm_room_retrofit.service.model.Posts;
import com.alamin.mvvm_room_retrofit.service.repository.MainActivityRepository;
import com.alamin.mvvm_room_retrofit.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel postViewModal;
    private PostAdapter postAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        postViewModal=new ViewModelProvider(this).get(MainActivityViewModel.class);

        postViewModal.getPostFromServer().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                postViewModal.insert(posts);
            }
        });
        postViewModal.getAllPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {

                postAdapter=new PostAdapter(getApplicationContext(),posts);
                recyclerView.setAdapter(postAdapter);
                Log.d("main", "onChanged: "+posts);
            }
        });
    }
}