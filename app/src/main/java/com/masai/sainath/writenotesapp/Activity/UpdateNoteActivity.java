package com.masai.sainath.writenotesapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.masai.sainath.writenotesapp.NOtesViewModel;
import com.masai.sainath.writenotesapp.Notes;
import com.masai.sainath.writenotesapp.R;
import com.masai.sainath.writenotesapp.databinding.ActivityInsertNotesBinding;
import com.masai.sainath.writenotesapp.databinding.ActivityUpdateNoteBinding;

import java.util.Date;

public class UpdateNoteActivity extends AppCompatActivity {

    ActivityUpdateNoteBinding binding;
    String priority ="1";
    String sTitle,sSubtitle,sPriority,sNotes;
    NOtesViewModel nOtesViewModel;
    int iid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot() );

        nOtesViewModel= ViewModelProviders.of(this).get(NOtesViewModel.class);


        iid=getIntent().getIntExtra("id",0);
        sTitle=getIntent().getStringExtra("title");
        sSubtitle=getIntent().getStringExtra("subtitle");
        sNotes=getIntent().getStringExtra("notes");
        sPriority=getIntent().getStringExtra("priority");

        binding.updateTitle.setText(sTitle);
        binding.updateSubtitle.setText(sSubtitle);
        binding.updateNotes.setText(sNotes);

        switch (sPriority){
            case "1":  binding.updategreen.setImageResource(R.drawable.ic_baseline_done_24);
            break;
            case "2":  binding.updateyellow.setImageResource(R.drawable.ic_baseline_done_24);
            break;
            case "3":  binding.updatered.setImageResource(R.drawable.ic_baseline_done_24);
            break;

        }


        binding.updategreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.updategreen.setImageResource(R.drawable.ic_baseline_done_24);
                binding.updateyellow.setImageResource(0);
                binding.updatered.setImageResource(0);
                priority="1";
            }
        });
        binding.updateyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.updategreen.setImageResource(0);
                binding.updateyellow.setImageResource(R.drawable.ic_baseline_done_24);
                binding.updatered.setImageResource(0);
                priority="2";

            }
        });
        binding.updatered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.updategreen.setImageResource(0);
                binding.updateyellow.setImageResource(0);
                binding.updatered.setImageResource(R.drawable.ic_baseline_done_24);
                priority="3";
            }
        });
        binding.UpdateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.UpdateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String  title=binding.updateTitle.getText().toString();
               String subtitle=binding.updateSubtitle.getText().toString();
                String notes=binding.updateNotes.getText().toString();
                UpdateNotesViews(title,subtitle,notes);
            }
        });
    }

    private void UpdateNotesViews(String title, String subtitle, String notes) {
        Date date= new Date();
        CharSequence sequence= DateFormat.format("MMMM d, yyyy",date.getTime());

        Notes updateNotes=new Notes();
        updateNotes.id=iid;
        updateNotes.notesTitle=title;
        updateNotes.notesSubTitle=subtitle;
        updateNotes.notes=notes;
        updateNotes.notesDate=sequence.toString();
        updateNotes.notesPriority=priority;
        nOtesViewModel.updateNote(updateNotes);
        Toast.makeText(this, "Notes updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deletemenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.id_delete){
            BottomSheetDialog sheetDialog=new BottomSheetDialog(UpdateNoteActivity.this,R.style.BottoSheetStyle);
            View view= LayoutInflater.from(UpdateNoteActivity.this)
                    .inflate(R.layout.bottomsheet,(LinearLayout) findViewById(R.id.mainLinearlayout));
            sheetDialog.setContentView(view);

            TextView yes,no;
            yes=view.findViewById(R.id.yes);
            no=view.findViewById(R.id.no);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nOtesViewModel.deleteNote(iid);
                    finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sheetDialog.dismiss();
                }
            });
            sheetDialog.show();


        }
        return true;
    }

}
