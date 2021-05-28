package com.alamin.mvvm_room_retrofit.service.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alamin.mvvm_room_retrofit.R;

public class PostViewHolder extends RecyclerView.ViewHolder
{
    public TextView id,name,age;
    public ImageView image;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        id=itemView.findViewById(R.id.id);
        name=itemView.findViewById(R.id.name);
        image=itemView.findViewById(R.id.image);
        age=itemView.findViewById(R.id.age);
    }
}