package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rusphoto.databinding.StoryBinding;

import java.util.ArrayList;

public class Story extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    RecyclerView.Adapter adapter;
    StoryBinding binding;
    ArrayList<String> users;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        binding = StoryBinding.inflate(getLayoutInflater());

        users = new ArrayList<>();
        for(int i=0; i<10; i++){
            users.add("Daniel # "+i);
        }
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        binding.recyclerView.setAdapter(adapter);

        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(Story.this, CreateUser.class));
        });

        setContentView(binding.getRoot());
    }
}
