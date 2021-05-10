package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.rusphoto.fragments.HomeFragment;
import com.example.rusphoto.fragments.StoryFragment;
import com.example.rusphoto.fragments.CameraFragment;

import com.example.rusphoto.story.Story;
import com.example.rusphoto.tesseract.Tesseract;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));


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
                        startActivity(new Intent(MainActivity.this, Tesseract.class));
                    case R.id.navigation_story:
                        openFragment(StoryFragment.newInstance("", ""));
                        startActivity(new Intent(MainActivity.this, Story.class));
                }
                return false;
            };

}