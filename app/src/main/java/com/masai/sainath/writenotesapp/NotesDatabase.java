package com.masai.sainath.writenotesapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notes.class},version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public  abstract  NotesDataAccessObject notesDataAccessObject();

    public  static  NotesDatabase INSTANCE;

    public  static  NotesDatabase getDatabaseInstances(Context context){

        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext()
                    ,NotesDatabase.class,
                    "Notes_DataBase").allowMainThreadQueries().build();
        }
        return  INSTANCE;
    }
}

