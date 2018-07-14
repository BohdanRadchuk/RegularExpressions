package controller;

import model.NoteBook;
import model.entity.Note;
import view.View;

public class Controller {
    private NoteBook noteBook;
    private Note note;
    private View view;

    public Controller (View view, NoteBook noteBook){
        this.view = view;
        this.noteBook = noteBook;
    }
}
