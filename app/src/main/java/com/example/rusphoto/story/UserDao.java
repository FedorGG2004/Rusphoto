package com.example.rusphoto.story;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rusphoto.story.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertAll(User... users);
}
