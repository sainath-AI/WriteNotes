package com.masai.sainath.writenotesapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.masai.sainath.writenotesapp.NOtesViewModel;
import com.masai.sainath.writenotesapp.Notes;
import com.masai.sainath.writenotesapp.R;
import com.masai.sainath.writenotesapp.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {

    ActivityInsertNotesBinding binding;

    String title,subtitle,notes;
    NOtesViewModel nOtesViewModel;
    String priority ="1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInsertNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot() );

        nOtesViewModel= ViewModelProviders.of(this).get(NOtesViewModel.class);

        binding.greenDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.greenDot.setImageResource(R.drawable.ic_baseline_done_24);
                binding.yellowDot.setImageResource(0);
                binding.RedDot.setImageResource(0);
                priority="1";
            }
        });
        binding.yellowDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.greenDot.setImageResource(0);
                binding.yellowDot.setImageResource(R.drawable.ic_baseline_done_24);
                binding.RedDot.setImageResource(0);
                priority="2";

            }
        });
        binding.RedDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.greenDot.setImageResource(0);
                binding.yellowDot.setImageResource(0);
                binding.RedDot.setImageResource(R.drawable.ic_baseline_done_24);
                priority="3";
            }
        });

        binding.DoneNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title=binding.etTitle.getText().toString();
                subtitle=binding.etsubTitle.getText().toString();
                notes=binding.etTakenotes.getText().toString();
                CreateNotes(title,subtitle,notes);
            }
        });
    }

    private void CreateNotes(String title, String subtitle, String notes) {

        Date date= new Date();
        CharSequence sequence= DateFormat.format("MMMM d YYYY",date.getTime());


        Notes notes1=new Notes();
        notes1.notesTitle=title;
        notes1.notesSubTitle=subtitle;
        notes1.notes=notes;
        notes1.notesDate=sequence.toString();
        notes1.notesPriority=priority;
        nOtesViewModel.insertNote(notes1);


        Toast.makeText(this, "Notes created successfully", Toast.LENGTH_SHORT).show();
        finish();




    }
}