package com.deveshsharma.makenotes.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deveshsharma.makenotes.R;
import com.deveshsharma.makenotes.model.Note;

import java.util.ArrayList;

class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView description;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_item);
        description = itemView.findViewById(R.id.description_item);
    }
}
public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    ArrayList<Note> notes;
    public NoteAdapter(ArrayList<Note> notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(adapterLayout);
    }


    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note item = notes.get(position);
        Log.i("Debug",item.title);
        Log.i("Debug",item.desc);
        holder.title.setText(item.title);
        holder.description.setText(item.desc);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
