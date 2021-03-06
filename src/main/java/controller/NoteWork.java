package controller;

import controller.util.CheckRegex;
import model.entity.Group;
import model.entity.Note;
import view.PropertyNames;
import view.View;

import java.util.*;

public class NoteWork {
    private Note note;
    private View view;

    public NoteWork(View view) {
        this.view = view;
    }

    public Note createNewNote() {
        note = new Note();
        setName(Controller.resourceBundle.getString(PropertyNames.CAPITALIZED_REGEX));
        setSurname(Controller.resourceBundle.getString(PropertyNames.CAPITALIZED_REGEX));
        setPatronymic(Controller.resourceBundle.getString(PropertyNames.CAPITALIZED_REGEX));
        note.generateSurnameAndInitial();
        setNickname(Controller.resourceBundle.getString(PropertyNames.NO_SPACES_REGEX), note);
        setComment(Controller.resourceBundle.getString(PropertyNames.ALL_SYMBOLS_REGEX));
        setGroup(Controller.resourceBundle.getString(PropertyNames.ENUM_WORDS_REGEX));
        setHomePhone(Controller.resourceBundle.getString(PropertyNames.HOME_PHONE_REGEX));
        setMobilePhone(Controller.resourceBundle.getString(PropertyNames.MOBILE_PHONE_REGEX));
        setSecondMobilePhone(Controller.resourceBundle.getString(PropertyNames.SECOND_MOBILE_PHONE_REGEX));
        setEmail(Controller.resourceBundle.getString(PropertyNames.EMAIL_REGEX));
        setSkype(Controller.resourceBundle.getString(PropertyNames.NO_SPACES_REGEX));
        setAddress(Controller.resourceBundle.getString(PropertyNames.ALL_NUMBERS_REGEX),
                Controller.resourceBundle.getString(PropertyNames.CAPITALIZED_REGEX));
        note.addModifyingDates(new Date());
        return note;
    }
    public Note editNoteNickname (Note note){
        setNickname(Controller.resourceBundle.getString(PropertyNames.NO_SPACES_REGEX), note);
        return note;
    }

    private void setName(String capitalizedStringRegex) {
        note.setName(getCorrectString(capitalizedStringRegex, PropertyNames.NAME_MESSAGE));
    }

    private void setSurname(String capitalizedStringRegex) {
        note.setSurname(getCorrectString(capitalizedStringRegex, PropertyNames.SURNAME_MESSAGE));
    }

    private void setPatronymic(String capitalizedStringRegex) {
        note.setPatronymic(getCorrectString(capitalizedStringRegex, PropertyNames.PATRONYMIC_MESSAGE));
    }

    private void setNickname(String exceptWhiteSpacesRegex, Note note) {
        note.setNickname(getCorrectString(exceptWhiteSpacesRegex, PropertyNames.NICKNAME_MESSAGE));
    }

    private void setComment(String exceptWhiteSpacesRegex) {
        note.setComment(getCorrectString(exceptWhiteSpacesRegex, PropertyNames.COMMENT_MESSAGE));
    }

    private void setGroup(String enumWordsRegex) {
        String afterRegexCheck = getCorrectString(enumWordsRegex, PropertyNames.GROUP_MESSAGE);
        checkEnum(afterRegexCheck, Group.valueOf(afterRegexCheck));
    }

    private void setHomePhone(String homePhoneRegex) {
        note.setHomePhone(getCorrectString(homePhoneRegex, PropertyNames.HOME_PHONE_MESSAGE));
    }

    private void setMobilePhone(String mobilePhoneRegex) {
        note.setMobilePhone(getCorrectString(mobilePhoneRegex, PropertyNames.MOBILE_PHONE_MESSAGE));
    }

    private void setSecondMobilePhone(String secondMobileRegex) {
        Optional<String> mobilePhone = Optional.empty();
        String input = getCorrectString(secondMobileRegex, PropertyNames.SECOND_MOBILE_PHONE_MESSAGE).toLowerCase();
        if (CheckRegex.checkRegexToInput(
                Controller.resourceBundle.getString(PropertyNames.MOBILE_PHONE_REGEX), input)) {
            mobilePhone = Optional.of(input);
        }
        note.setSecondMobilePhone(mobilePhone);
    }

    private void setEmail(String emailRegex) {
        note.setEmail(getCorrectString(emailRegex, PropertyNames.EMAIL_MESSAGE));
    }

    private void setSkype(String allSymbolsRegex) {
        note.setSkype(getCorrectString(allSymbolsRegex, PropertyNames.SKYPE_MESSAGE));
    }

    private void setAddress(String numbersRegex, String capitalizedStringRegex) {
        int index = Integer.valueOf(getCorrectString(numbersRegex, PropertyNames.INDEX_MESSAGE));
        String city = getCorrectString(capitalizedStringRegex, PropertyNames.CITY_MESSAGE);
        String street = getCorrectString(capitalizedStringRegex, PropertyNames.STREET_MESSAGE);
        int houseNumber = Integer.valueOf(getCorrectString(numbersRegex, PropertyNames.HOUSE_NUMBER_MESSAGE));
        int flatNumber = Integer.valueOf(getCorrectString(numbersRegex, PropertyNames.FLAT_NUMBER_MESSAGE));
        note.setAddress(index, city, street, houseNumber, flatNumber);
    }

    private void checkEnum(String regexedEnumName, Group group) {
        if (regexedEnumName.equals(group.toString())) {
            note.setGroup(group);
        }
    }

    private String getCorrectString(String regex, String requirementsMessage) {
        String input;
        boolean checkResult;
        do {
            view.printMessage(Controller.resourceBundle.getString(PropertyNames.INPUT_DATA_REQUEST) +
                    Controller.resourceBundle.getString(requirementsMessage));
            input = Controller.scanner.nextLine();
            checkResult = CheckRegex.checkRegexToInput(regex, input);
            if (!checkResult) {
                view.printMessage(Controller.resourceBundle.getString(PropertyNames.WRONG_INPUT));
            }
        } while (!checkResult);
        return input;
    }
}
