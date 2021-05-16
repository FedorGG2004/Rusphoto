package com.example.rusphoto.story;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.rusphoto.R;
import com.example.rusphoto.databinding.StoryBinding;
import com.example.rusphoto.fragments.CameraFragment;
import com.example.rusphoto.fragments.HomeFragment;
import com.example.rusphoto.fragments.StoryFragment;
import com.example.rusphoto.tesseract.Tesseract;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Story extends AppCompatActivity {
    UserAdapter adapter;
    StoryBinding binding;
    BottomNavigationView bottomNavigation;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);
        System.out.println("story_activity_1111111111111111111111111");
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));

        binding = StoryBinding.inflate(getLayoutInflater());

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        List<User> users = db.userDao().getAllUsers();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        binding.recyclerView.setAdapter(adapter);

        binding.button4.setOnClickListener(v -> {
            db.userDao().deleteUser(users.get(0));
            adapter.users.remove(0);
            adapter.notifyDataSetChanged();

        });

        binding.button.setOnClickListener(v -> {
            startActivity(new Intent(Story.this, CreateUser.class));
        });

        setContentView(binding.getRoot());
    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(HomeFragment.newInstance("", ""));
                        return true;
                    case R.id.navigation_camera:
                        openFragment(CameraFragment.newInstance("", ""));
                        startActivity(new Intent(Story.this, Tesseract.class));
                    case R.id.navigation_story:
                        openFragment(StoryFragment.newInstance("", ""));
                        return true;
                }
                return false;
            };
}
