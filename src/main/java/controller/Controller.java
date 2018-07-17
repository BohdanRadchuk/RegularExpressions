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

    public static Scanner scanner = new Scanner(System.in);

    public Controller(View view, NoteBook noteBook) {
        this.view = view;
        this.noteBook = noteBook;
        this.note = new Note();
        this.fieldsFilling = new FieldsFilling(view);
    }

    public void createNewNote() {
        getUSBundleData();

        noteBook.addNote(fieldsFilling.createNewNote());

        view.printMessage(noteBook.toString());
    }

    private static void getUSBundleData() {
        Locale.setDefault(Locale.US);
//        Locale.setDefault(new Locale("ru", "RU"));
        resourceBundle = ResourceBundle.getBundle(View.PROPERTY_FILE_NAME, Locale.getDefault());
    }
}
