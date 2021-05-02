package com.example.rusphoto;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.rusphoto.databinding.CreateUserBinding;

public class CreateUser extends AppCompatActivity {
    private static final String TAG = "CreateUser";
    CreateUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CreateUserBinding.inflate(getLayoutInflater());

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();
        binding.button.setOnClickListener(v -> {
            for (int i = 0; i < 10; i++) {
                User user = new User(binding.firstName.getText().toString(), binding.lastName.getText().toString(), binding.email.getText().toString());
                db.userDao().insertAll(user);
            }
                startActivity(new Intent(CreateUser.this, Story.class));
            });

        setContentView(binding.getRoot());
    }
}
