package model;

import model.entity.Note;

import java.util.ArrayList;
import java.util.Date;

public class NoteBook {
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Date> creationDates = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
        creationDates.add(new Date());
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "notes=" + notes +
                ", creationDates=" + creationDates +
                '}';
    }
}
