package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rusphoto.databinding.StoryBinding;

public class Story extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    RecyclerView.Adapter adapter;
    StoryBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        binding = StoryBinding.inflate(getLayoutInflater());

        binding.recyclerView.setOnClickListener((View.OnClickListener) new LinearLayoutManager(this));
        adapter = new UserAdapter();
        binding.recyclerView.setAdapter(adapter);

        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(Story.this, CreateUser.class));
        });

        setContentView(binding.getRoot());
    }
}
