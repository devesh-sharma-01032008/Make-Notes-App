package com.deveshsharma.makenotes.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deveshsharma.makenotes.R;
import com.deveshsharma.makenotes.db.DBHelper;
import com.deveshsharma.makenotes.db.NoteDbController;
import com.deveshsharma.makenotes.model.Note;

import java.util.ArrayList;

class NoteViewHolder extends RecyclerView.ViewHolder {
    Button delete_btn;
    TextView title;
    TextView description;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_item);
        description = itemView.findViewById(R.id.description_item);
        delete_btn = itemView.findViewById(R.id.delete_btn);

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
        holder.title.setText(item.title);
        holder.description.setText(item.desc);
        holder.delete_btn.setOnClickListener(view -> {
            long sno = item.sno;
            String title = item.title;
            String desc = item.desc;
            Note note = new Note(sno,title,desc);
            DBHelper db_helper = new DBHelper(view.getContext());
            NoteDbController db = new NoteDbController();
            db.deleteNote(db_helper,note);
            ArrayList<Note> notes_updated = new ArrayList<>(db.getNotes(db_helper));
            Log.i("debug", String.valueOf(notes_updated.size()));
            notes.clear();
            notes.addAll(notes_updated);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
