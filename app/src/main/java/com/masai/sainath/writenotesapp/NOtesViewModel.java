package com.masai.sainath.writenotesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NOtesViewModel extends AndroidViewModel {

    public  NotesRepository repository;
    public LiveData<List<Notes>> getALlNotes;


    public NOtesViewModel(Application application) {
        super(application);

         repository = new NotesRepository(application);
         getALlNotes=repository.getALlNotes;

    }
   public void  insertNote(Notes notes){
        repository.insertNotes(notes);
    }
   public void  deleteNote(int id){
        repository.deleteNotes(id);
    }
   public void  updateNote(Notes notes){
        repository.UpdateNotes(notes);
    }
}