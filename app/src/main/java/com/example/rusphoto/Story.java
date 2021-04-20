package com.example.rusphoto;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rusphoto.databinding.ActivityMainBinding;
import com.example.rusphoto.databinding.StoryBinding;

public class Story extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    StoryBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        binding = StoryBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(v -> {
            Log.d(TAG, "Pressed");
        });

        setContentView(binding.getRoot());
    }
}
