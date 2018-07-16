package model;

import model.entity.Note;

import java.text.DateFormat;
import java.util.ArrayList;

public class NoteBook {
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<DateFormat> creationDates;

    public void addNote (Note note){
        notes.add(note);
    }

}
