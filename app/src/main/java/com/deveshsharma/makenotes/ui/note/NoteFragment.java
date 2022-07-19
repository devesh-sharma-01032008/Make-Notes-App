package com.deveshsharma.makenotes.ui.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        new ViewModelProvider(this).get(NoteViewModel.class);

        binding = FragmentNoteBinding.inflate(inflater, container, false);
        NoteDbController db = new NoteDbController();
        DBHelper dbHelper = new DBHelper(getContext());
        ArrayList<Note> notes = new ArrayList<>(db.getNotes(dbHelper));
        NoteAdapter adapter = new NoteAdapter(notes);
        binding.notesView.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
