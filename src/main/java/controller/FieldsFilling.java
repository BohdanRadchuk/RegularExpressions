package controller;

import controller.util.CheckRegex;
import model.entity.Group;
import model.entity.Note;
import view.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FieldsFilling {
    private Note note;
    private View view;


    public FieldsFilling( View view) {
        this.view = view;
    }



    public Note createNewNote() {
        note = new Note();
        setName(Controller.resourceBundle.getString("capitalizedString"));
        setSurname(Controller.resourceBundle.getString("capitalizedString"));
        setPatronymic(Controller.resourceBundle.getString("capitalizedString"));
        setNickname(Controller.resourceBundle.getString("exceptWhiteSpaces"));
        setComment(Controller.resourceBundle.getString("allSymbols"));
        setGroup(Controller.resourceBundle.getString("enumWords"));
        setHomePhone(Controller.resourceBundle.getString("homePhone"));
        setMobilePhone(Controller.resourceBundle.getString("mobilePhone"));
        setSecondMobilePhone(Controller.resourceBundle.getString("secondMobilePhone"));
        setEmail(Controller.resourceBundle.getString("email"));
        setSkype(Controller.resourceBundle.getString("allSymbols"));
        setAddress(Controller.resourceBundle.getString("allNumbers"),
                Controller.resourceBundle.getString("capitalizedString"));
        note.addModifyingDates(new Date());

        return note;

    }

    private void setGroup(String enumWordsRegex) {
        String afterRegexCheck = getCorrectString(enumWordsRegex);

        checkEnum(afterRegexCheck, Group.valueOf(afterRegexCheck));

    }

    private void checkEnum(String regexedEnumName, Group group) {
        if (regexedEnumName.equals(group.toString())) {
            note.setGroup(group);
            System.out.println(group);
        }
    }

    private void setAddress(String numbersRegex, String capitalizedStringRegex) {
        int index = Integer.valueOf(getCorrectString(numbersRegex));
        String city = getCorrectString(capitalizedStringRegex);
        String street = getCorrectString(capitalizedStringRegex);
        int houseNumber = Integer.valueOf(getCorrectString(numbersRegex));
        int flatNumber = Integer.valueOf(getCorrectString(numbersRegex));
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
        boolean checkResult;
        do {

            view.printMessage(Controller.resourceBundle.getString(View.INPUT_DATA_REQUEST) + regex);
            input = Controller.scanner.next();
            checkResult = CheckRegex.checkInputToRegex(regex, input);
            if (!checkResult) {
                view.printMessage(Controller.resourceBundle.getString(View.WRONG_INPUT));
            }
        } while (!checkResult);
        return input;
    }


}
