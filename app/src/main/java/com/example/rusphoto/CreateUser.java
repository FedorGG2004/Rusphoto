package com.example.rusphoto;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rusphoto.databinding.CreateUserBinding;

public class CreateUser extends AppCompatActivity {
    private static final String TAG = "CreateUser";
    CreateUserBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CreateUserBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(v -> {

            });

        setContentView(binding.getRoot());
    }
}
