package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.rusphoto.databinding.ActivityMainBinding;
import com.example.rusphoto.fragments.HomeFragment;
import com.example.rusphoto.fragments.NotificationFragment;
import com.example.rusphoto.fragments.SmsFragment;
import com.example.rusphoto.story.Story;
import com.example.rusphoto.tesseract.Tesseract;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Tesseract.class);
            startActivity(intent);
        });
        binding.button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Story.class);
            startActivity(intent);
        });
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));

        setContentView(binding.getRoot());
    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_sms:
                            openFragment(SmsFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_notifications:
                            openFragment(NotificationFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

}