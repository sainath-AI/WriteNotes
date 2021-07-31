package com.masai.sainath.writenotesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.masai.sainath.writenotesapp.NOtesViewModel;
import com.masai.sainath.writenotesapp.Notes;
import com.masai.sainath.writenotesapp.NotesAdapter;
import com.masai.sainath.writenotesapp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mBtnNewNotes;
    NOtesViewModel nOtesViewModel;
    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    TextView nofilter,highttolow,lowtohigh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnNewNotes = findViewById(R.id.newNotes);
        recyclerView = findViewById(R.id.recyclerview);

        nofilter = findViewById(R.id.noFilter);
        highttolow = findViewById(R.id.hightolow);
        lowtohigh = findViewById(R.id.lowtohigh);

        nofilter.setBackgroundResource(R.drawable.selectfilershape);

        nofilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData(0);
                highttolow.setBackgroundResource(R.drawable.fiiltershape);
                lowtohigh.setBackgroundResource(R.drawable.fiiltershape);
                nofilter.setBackgroundResource(R.drawable.selectfilershape);
            }
        });
        highttolow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highttolow.setBackgroundResource(R.drawable.selectfilershape);
                lowtohigh.setBackgroundResource(R.drawable.fiiltershape);
                nofilter.setBackgroundResource(R.drawable.fiiltershape);
            }
        });
        lowtohigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highttolow.setBackgroundResource(R.drawable.fiiltershape);
                lowtohigh.setBackgroundResource(R.drawable.selectfilershape);
                nofilter.setBackgroundResource(R.drawable.fiiltershape);

            }
        });

        nOtesViewModel = ViewModelProviders.of(this).get(NOtesViewModel.class);


        mBtnNewNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertNotesActivity.class));

            }
        });
        nOtesViewModel.getALlNotes.observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                setAdapter(notes);
            }
        });
    }

    private void loadData(int i) {
        if (i==0){
            nOtesViewModel.getALlNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }else if (i==1){
            nOtesViewModel.HIghTOLow.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }else if (i==2){
            nOtesViewModel.LowToHigh.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                }
            });
        }
    }

    private void setAdapter(List<Notes> notes) {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
          notesAdapter=new NotesAdapter(MainActivity.this,notes);
            recyclerView.setAdapter(notesAdapter);
    }
//        nOtesViewModel.getALlNotes.observe(this,notes ->{
//            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
//           notesAdapter=new NotesAdapter(MainActivity.this,notes);
//            recyclerView.setAdapter(notesAdapter);
//        });



}