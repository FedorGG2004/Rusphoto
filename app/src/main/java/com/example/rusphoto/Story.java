package com.example.rusphoto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rusphoto.databinding.ActivityMainBinding;
import com.example.rusphoto.databinding.StoryBinding;

public class Story extends AppCompatActivity {
    StoryBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        binding = StoryBinding.inflate(getLayoutInflater());


        setContentView(binding.getRoot());
    }
}
