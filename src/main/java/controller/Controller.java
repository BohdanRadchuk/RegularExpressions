package controller;

import model.NoteBook;
import model.entity.Note;
import view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private NoteBook noteBook;
    private Note note;
    private View view;
    public static ResourceBundle resourceBundle;
    private FieldsFilling fieldsFilling;
    // private CheckRegex checkRegex = new CheckRegex();

    public static Scanner scanner = new Scanner(System.in);

    public Controller(View view, NoteBook noteBook) {
        this.view = view;
        this.noteBook = noteBook;
        this.note = new Note();
        this.fieldsFilling = new FieldsFilling(view);
    }

    public void createNewNote() {
        getUSBundleData();
        note = fieldsFilling.createNewNote();
        noteBook.addNote(note);

        System.out.println(note);
        System.out.println(noteBook);
    }

    private static void getUSBundleData() {
        System.out.println(Locale.getDefault());
        Locale.setDefault(Locale.US);
        System.out.println(Locale.getDefault());
        resourceBundle = ResourceBundle.getBundle("constants", Locale.getDefault());
    }
}
