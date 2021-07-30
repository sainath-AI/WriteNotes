package com.masai.sainath.writenotesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.sainath.writenotesapp.Activity.MainActivity;

import java.util.List;

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{

    MainActivity mainActivity;
    List<Notes> notes;
    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity=mainActivity;
        this.notes=notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_notes,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder( NotesAdapter.NotesViewHolder holder, int position) {
        Notes note = notes.get(position);



        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubTitle);
        holder.notesData.setText(note.notesDate);
        if  (note.notesPriority.equals("1")){
            holder.notesPriority.setBackgroundResource(R.drawable.greenshape);

        }else if (note.notesPriority.equals("2")){
            holder.notesPriority.setBackgroundResource(R.drawable.yelloeshape);
        }else if(note.notesPriority.equals("3")){
            holder.notesPriority.setBackgroundResource(R.drawable.redshape);
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView title,subtitle,notesData;
        View notesPriority;


        public NotesViewHolder(@NonNull  View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.notesTitle);
            subtitle=itemView.findViewById(R.id.notesSubtitle);
            notesData=itemView.findViewById(R.id.notesDate);
            notesPriority=itemView.findViewById(R.id.notespriority);

        }


    }
}
