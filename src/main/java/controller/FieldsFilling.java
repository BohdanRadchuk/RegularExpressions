package controller;

import controller.util.CheckRegex;
import model.entity.Group;
import model.entity.Note;
import view.PropertyNames;
import view.View;

import java.util.*;

public class FieldsFilling {
    private Note note;
    private View view;

    public FieldsFilling(View view) {
        this.view = view;
    }

    public Note createNewNote() {
        note = new Note();
        setName(Controller.resourceBundle.getString(PropertyNames.CAPITALIZED));
        setSurname(Controller.resourceBundle.getString(PropertyNames.CAPITALIZED));
        setPatronymic(Controller.resourceBundle.getString(PropertyNames.CAPITALIZED));
        note.generateSurnameAndInitial();
        setNickname(Controller.resourceBundle.getString(PropertyNames.NO_SPACES));
        setComment(Controller.resourceBundle.getString(PropertyNames.ALL_SYMBOLS));
        setGroup(Controller.resourceBundle.getString(PropertyNames.ENUM_WORDS));
        setHomePhone(Controller.resourceBundle.getString(PropertyNames.HOME_PHONE));
        setMobilePhone(Controller.resourceBundle.getString(PropertyNames.MOBILE_PHONE));
        setSecondMobilePhone(Controller.resourceBundle.getString(PropertyNames.SECOND_MOBILE_PHONE));
        setEmail(Controller.resourceBundle.getString(PropertyNames.EMAIL));
        setSkype(Controller.resourceBundle.getString(PropertyNames.NO_SPACES));
        setAddress(Controller.resourceBundle.getString(PropertyNames.ALL_NUMBERS),
                Controller.resourceBundle.getString(PropertyNames.CAPITALIZED));
        note.addModifyingDates(new Date());
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

    private void setNickname(String exceptWhiteSpacesRegex) {
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
        Optional<String> mobilePhone = Optional.of(getCorrectString(secondMobileRegex,
                PropertyNames.SECOND_MOBILE_PHONE_MESSAGE));
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
            checkResult = CheckRegex.checkInputToRegex(regex, input);
            if (!checkResult) {
                view.printMessage(Controller.resourceBundle.getString(PropertyNames.WRONG_INPUT));
            }
        } while (!checkResult);
        return input;
    }
}
