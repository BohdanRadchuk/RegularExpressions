package controller;

import controller.util.CheckRegex;
import model.NoteBook;
import model.entity.Group;
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

//        setName(resourceBundle.getString("capitalizedString"));
//        setSurname (resourceBundle.getString("capitalizedString"));
//        setPatronymic (resourceBundle.getString("capitalizedString"));
//        setNickname (resourceBundle.getString("exceptWhiteSpaces"));
//        setComment (resourceBundle.getString("allSymbols"));
          setGroup (resourceBundle.getString("enumWords"));
//        setHomePhone (resourceBundle.getString("homePhone"));
//        setMobilePhone(resourceBundle.getString("mobilePhone"));
//        setSecondMobilePhone(resourceBundle.getString("secondMobilePhone"));
//        setEmail(resourceBundle.getString("email"));
//        setSkype(resourceBundle.getString("allSymbols"));
//        setAddress();

        System.out.println(note);
    }

    private void setGroup(String enumWordsRegex) {      //TODO
        String asd = getCorrectString(enumWordsRegex);
        if (asd.equals(Group.FRIENDS)){
            note.setGroup(Group.valueOf(asd));
            System.out.println(asd);
        } else if (asd.equals(Group.COWORKERS)){
            System.out.println(asd);
        } else if (asd.equals(Group.FAMILY)){
            System.out.println(asd);
        }
    }

    private void setAddress() {
        int index = Integer.valueOf(getCorrectString(resourceBundle.getString("allNumbers")));
        String city = getCorrectString(resourceBundle.getString("capitalizedString"));
        String street = getCorrectString(resourceBundle.getString("capitalizedString"));
        int houseNumber = Integer.valueOf(getCorrectString(resourceBundle.getString("allNumbers")));
        int flatNumber = Integer.valueOf(getCorrectString(resourceBundle.getString("allNumbers")));
        note.setAddress(index, city, street, houseNumber, flatNumber);
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
