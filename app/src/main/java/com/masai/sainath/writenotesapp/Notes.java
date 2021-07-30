package com.masai.sainath.writenotesapp;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_DataBase")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="notes_titles")
   public String notesTitle;

    @ColumnInfo(name="notes_subtitles")
   public String notesSubTitle;

    @ColumnInfo(name="notes_date")
   public String notesDate;

    @ColumnInfo(name="notes")
   public String notes;

    @ColumnInfo(name="notes_priority")
   public String notesPriority;

}
