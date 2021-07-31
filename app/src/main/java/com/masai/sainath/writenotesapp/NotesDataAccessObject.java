package com.masai.sainath.writenotesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDataAccessObject {

    @Query("SELECT * FROM Notes_DataBase")
    LiveData<List<Notes>> getAllNotes();

    @Query("SELECT * FROM Notes_DataBase ORDER BY notes_priority DESC")
    LiveData<List<Notes>> HighToLow();

    @Query("SELECT * FROM Notes_DataBase ORDER BY notes_priority ASC ")
    LiveData<List<Notes>> LowToHigh();

    //List<Notes> getALlNotes();

    @Insert
    void insertNotes(Notes... notes);

   @Query("DELETE FROM Notes_DataBase WHERE id=:id")
    void  deleteNotes(int  id);

    @Update
    void UpdateNotes(Notes notes);

}
