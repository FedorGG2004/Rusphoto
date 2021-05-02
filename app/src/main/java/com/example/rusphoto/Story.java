package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rusphoto.databinding.StoryBinding;

public class Story extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    StoryBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        binding = StoryBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(Story.this, CreateUser.class));
        });

        setContentView(binding.getRoot());
    }
}
