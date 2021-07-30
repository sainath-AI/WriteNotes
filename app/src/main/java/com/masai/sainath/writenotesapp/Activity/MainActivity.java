package com.masai.sainath.writenotesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.masai.sainath.writenotesapp.NOtesViewModel;
import com.masai.sainath.writenotesapp.NotesAdapter;
import com.masai.sainath.writenotesapp.R;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mBtnNewNotes;
    NOtesViewModel nOtesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnNewNotes=findViewById(R.id.newNotes);
        recyclerView=findViewById(R.id.recyclerview);

        nOtesViewModel= ViewModelProviders.of(this).get(NOtesViewModel.class);


        mBtnNewNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InsertNotesActivity.class));

            }
        });
        nOtesViewModel.getALlNotes.observe(this,notes ->{
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
           notesAdapter=new NotesAdapter(MainActivity.this,notes);
            recyclerView.setAdapter(notesAdapter);
        });

    }
}