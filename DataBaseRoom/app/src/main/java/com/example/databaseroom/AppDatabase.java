package com.example.databaseroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;
    public abstract UserDao userDao();

    public static AppDatabase getInstance(Context context){
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context, AppDatabase.class, "database builder").build();
            return mInstance;
        }
        return mInstance;
    }
}
