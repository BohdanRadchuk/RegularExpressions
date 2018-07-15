package controller;

import controller.util.CheckRegex;
import model.NoteBook;
import model.entity.Note;
import view.View;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private NoteBook noteBook;
    private Note note;
    private View view;
    private ResourceBundle resourceBundle;
    private FieldsFilling fieldsFilling;
    // private CheckRegex checkRegex = new CheckRegex();

    private Scanner scanner = new Scanner(System.in);

    public Controller(View view, NoteBook noteBook) {
        this.view = view;
        this.noteBook = noteBook;
        this.note = new Note();
        this.fieldsFilling = new FieldsFilling(note);
    }

    public void createNewNote() {
        getUSBundleData();

        //setName(resourceBundle.getString("capitalizedStringRegex"));
        /*setSurname (resourceBundle.getString("capitalizedStringRegex"));
        setPatronymic (resourceBundle.getString("capitalizedStringRegex"));*/
        //setNickname (resourceBundle.getString("exceptWhiteSpaces"));
        //setComment (resourceBundle.getString("allSymbols"));
        //setGroup (resourceBundle.getString(""));
        //setHomePhone (resourceBundle.getString("homePhone"));
        //setMobilePhone(resourceBundle.getString("mobilePhone"));
        //setSecondMobilePhone(resourceBundle.getString("secondMobilePhone"));
        //setEmail(resourceBundle.getString("email"));
        setSkype(resourceBundle.getString("allSymbols"));
        //setAddress()

        System.out.println(note);
    }

    private void setSkype(String allSymbolsRegex) {
        note.setSkype(getCorrectString(allSymbolsRegex));
    }

    private void setEmail(String emailRegex) {
        note.setEmail(getCorrectString(emailRegex));
    }

    private void setSecondMobilePhone(String secondMobileRegex) {
        Optional<String> mobilePhone = Optional.of(getCorrectString(secondMobileRegex));
        note.setSecondMobilePhone(mobilePhone);
    }

    private void setMobilePhone(String mobilePhoneRegex) {
        note.setMobilePhone(getCorrectString(mobilePhoneRegex));
    }

    private void setHomePhone(String homePhoneRegex) {
        note.setHomePhone(getCorrectString(homePhoneRegex));
    }

    private void setComment(String exceptWhiteSpacesRegex) {
        note.setComment(getCorrectString(exceptWhiteSpacesRegex));
    }

    private void setNickname(String exceptWhiteSpacesRegex) {
        note.setNickname(getCorrectString(exceptWhiteSpacesRegex));
    }


    private void setSurname(String capitalizedStringRegex) {
        note.setSurname(getCorrectString(capitalizedStringRegex));
    }

    private void setName(String capitalizedStringRegex) {
        note.setName(getCorrectString(capitalizedStringRegex));
    }

    private void setPatronymic(String capitalizedStringRegex) {
        note.setPatronymic(getCorrectString(capitalizedStringRegex));
    }

    private String getCorrectString(String regex) {
        String input;
        do {
            view.printMessage(resourceBundle.getString(View.INPUT_DATA_REQUEST) + regex);
            input = scanner.next();
        } while (!CheckRegex.checkInputToRegex(regex, input));
        return input;
    }

    public void getUSBundleData() {
        System.out.println(Locale.getDefault());
        Locale.setDefault(Locale.US);
        System.out.println(Locale.getDefault());
        this.resourceBundle = ResourceBundle.getBundle("constants", Locale.getDefault());
    }
}
