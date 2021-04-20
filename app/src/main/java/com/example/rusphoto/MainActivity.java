package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.example.rusphoto.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Tesseract.class);
            startActivity(intent);
        });
        binding.button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Story.class);
            startActivity(intent);
        });
        setContentView(binding.getRoot());
    }

}