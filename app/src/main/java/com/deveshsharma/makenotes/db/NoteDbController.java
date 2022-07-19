package com.deveshsharma.makenotes.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.deveshsharma.makenotes.model.Note;

import java.util.ArrayList;

public final class NoteDbController {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "NOTES.db";

    public static class NoteColumns implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String SNO = "sno";
        public static final String TITLE = "title";
        public static final String DESC = "desc";
        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + NoteColumns.TABLE_NAME
                + " (" + NoteColumns.SNO + " INTEGER(214748364) PRIMARY KEY ,"
                + NoteColumns.TITLE + " TEXT(500),"
                + NoteColumns.DESC + " TEXT(1000));";
        public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + NoteColumns.TABLE_NAME + ";";
    }

    public void insertNote(DBHelper db, Note note) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db_writable = db.getWritableDatabase();
        values.put(NoteColumns.TITLE, note.title);
        values.put(NoteColumns.DESC, note.desc);
        db_writable.insert(NoteColumns.TABLE_NAME, null, values);
    }

    //    public ArrayList<Long> getNotes(DBHelper db){
//        ArrayList<Long> notes;
//        notes = new ArrayList<>();
//        SQLiteDatabase db_readable = db.getReadableDatabase();
//        String[] projection = {
//                NoteColumns.SNO,
//                NoteColumns.TITLE,
//                NoteColumns.DESC
//        };
//        String selection = NoteColumns.TITLE + " = ?";
//        String[] selectionArgs = {
//                ""
//        };
//        String sortOrder = NoteColumns.SNO + " ASC";
//        Cursor cursor = db_readable.query(NoteColumns.TABLE_NAME, projection,selection,selectionArgs,null,null,sortOrder);
//        while(cursor.moveToNext()){
//            long note_id = cursor.getColumnIndexOrThrow(NoteColumns.SNO);
//            notes.add(note_id);
//        }
//        cursor.close();
//        return notes;
//    }
    public ArrayList<Note> getNotes(DBHelper db) {
        SQLiteDatabase db_readable = db.getReadableDatabase();
        ArrayList<Note> notes;
        notes = new ArrayList<Note>();
        Cursor resultSet = db_readable.rawQuery("SELECT * FROM notes",null);
        resultSet.moveToFirst();
        while(resultSet.moveToNext()){
            long sno  = resultSet.getLong(0);
            String title  = resultSet.getString(1);
            String desc  = resultSet.getString(1);
            Note note = new Note(sno,title,desc);
            notes.add(note);
        }
        resultSet.close();
        return notes;
    }
}



