package com.alamin.mvvm_room_retrofit.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alamin.mvvm_room_retrofit.R;
import com.alamin.mvvm_room_retrofit.service.model.Post;
import com.alamin.mvvm_room_retrofit.service.viewHolder.PostViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder>{

    private Context context;
    private List<Post> postsList;

    public PostAdapter(Context context, List<Post> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(context).inflate(R.layout.each_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post posts=postsList.get(position);
        holder.id.setText("Id : " +posts.getId());
        holder.name.setText("Name : "+posts.getName());
        holder.age.setText("Age : "+posts.getAge());
        Glide.with(context)
                .load(posts.getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

}
