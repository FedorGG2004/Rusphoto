package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.rusphoto.databinding.StoryBinding;

import java.util.List;

public class Story extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    RecyclerView.Adapter adapter;
    StoryBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        binding = StoryBinding.inflate(getLayoutInflater());

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        List<User> users = db.userDao().getAllUsers();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        binding.recyclerView.setAdapter(adapter);

        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(Story.this, CreateUser.class));
        });

        setContentView(binding.getRoot());
    }
}
