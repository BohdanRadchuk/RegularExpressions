package controller;

import model.NoteBook;
import model.entity.Note;
import view.PropertyNames;
import view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private NoteBook noteBook;
    private Note note;
    private View view;
    public static ResourceBundle resourceBundle;
    private NoteWork noteWork;

    public static Scanner scanner = new Scanner(System.in);

    public Controller(View view, NoteBook noteBook) {
        this.view = view;
        this.noteBook = noteBook;
        this.note = new Note();
        this.noteWork = new NoteWork(view);
        getUSBundleData();
    }


    public void createNewNote() {

        for (int i = 0; i < 3; i++) {
            note = noteWork.createNewNote();
            while (!checkLogin(note));
            noteBook.addNote(note);
        }
        view.printMessage(noteBook.toString());
    }

    private boolean checkLogin(Note note) {
        try {
            noteBook.checkLoginInNotebook(note);
            return true;
        } catch (LoginMatchException e) {
            view.printMessage(resourceBundle.getString(PropertyNames.LOGIN_EXISTS));
            e.printStackTrace();
            noteWork.editNoteNickname(note);
            return false;
        }
    }


    private static void getUSBundleData() {
        Locale.setDefault(Locale.US);
//        Locale.setDefault(new Locale("ru", "RU"));
        resourceBundle = ResourceBundle.getBundle(View.PROPERTY_FILE_NAME, Locale.getDefault());
    }
}
