package com.deveshsharma.makenotes.ui.addnote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.deveshsharma.makenotes.databinding.FragmentAddNoteBinding;
import com.deveshsharma.makenotes.db.DBHelper;
import com.deveshsharma.makenotes.db.NoteDbController;
import com.deveshsharma.makenotes.model.Note;

public class AddNoteFragment extends Fragment {
    private FragmentAddNoteBinding binding;
    private final NoteDbController db_helper = new NoteDbController();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false);
        binding.saveNote.setOnClickListener(view -> {
            String title = binding.title.getText().toString();
            String desc = binding.desc.getText().toString();
            DBHelper db = new DBHelper(getContext());
            Note note = new Note(title,desc);
            Toast.makeText(getContext(), "Added Note Successfully", Toast.LENGTH_SHORT).show();
            db_helper.insertNote(db,note);
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
