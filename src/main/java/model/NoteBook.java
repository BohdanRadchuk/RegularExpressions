package model;

import controller.LoginMatchException;
import model.entity.Note;

import java.util.ArrayList;
import java.util.Date;

public class NoteBook {
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Date> creationDates = new ArrayList<>();

    public boolean addNote(Note note) {

        notes.add(note);
        creationDates.add(new Date());
        return true;
    }

    public void checkLoginInNotebook(Note note) throws LoginMatchException {
        for (Note baseNote : notes) {
            if (!notes.isEmpty() && baseNote.getNickname().equals(note.getNickname())) {
                throw new LoginMatchException();
            }
        }
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "notes=" + notes +
                ", creationDates=" + creationDates +
                '}';
    }
}
