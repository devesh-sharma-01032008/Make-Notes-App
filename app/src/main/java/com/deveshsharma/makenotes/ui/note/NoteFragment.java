package com.deveshsharma.makenotes.ui.note;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.deveshsharma.makenotes.adapter.NoteAdapter;
import com.deveshsharma.makenotes.databinding.FragmentNoteBinding;
import com.deveshsharma.makenotes.db.DBHelper;
import com.deveshsharma.makenotes.db.NoteDbController;
import com.deveshsharma.makenotes.model.Note;

import java.util.ArrayList;

public class NoteFragment  extends Fragment {
    private FragmentNoteBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNoteBinding.inflate(inflater, container, false);
        NoteDbController db = new NoteDbController();
        DBHelper dbHelper = new DBHelper(getContext());
        ArrayList<Note> notes = new ArrayList<>(db.getNotes(dbHelper));
        if(notes.size() >= 1){
            binding.noNotesMsg.setText("");
        }
        NoteAdapter adapter = new NoteAdapter(notes);
        binding.notesView.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        NoteDbController db = new NoteDbController();
        DBHelper dbHelper = new DBHelper(getContext());
        ArrayList<Note> notes = new ArrayList<>(db.getNotes(dbHelper));
        if(notes.size() >= 1){
            binding.noNotesMsg.setText("");
        }
        NoteAdapter adapter = new NoteAdapter(notes);
        binding.notesView.setAdapter(adapter);
    }
}
