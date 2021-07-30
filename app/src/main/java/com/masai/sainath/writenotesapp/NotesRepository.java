package com.masai.sainath.writenotesapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepository {


    public  NotesDataAccessObject notesDataAccessObject;
    public LiveData<List<Notes>> getALlNotes;

     public  NotesRepository(Application application){
         NotesDatabase database= NotesDatabase.getDatabaseInstances(application);
         notesDataAccessObject=database.notesDataAccessObject();
         getALlNotes=notesDataAccessObject.getAllNotes();
     }

    public void  insertNotes(Notes notes){
         notesDataAccessObject.insertNotes(notes);
     }
    public void  deleteNotes(int  id){
         notesDataAccessObject.deleteNotes(id);
     }
     public void UpdateNotes(Notes notes){
         notesDataAccessObject.UpdateNotes(notes);
     }
}
