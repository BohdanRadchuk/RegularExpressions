package model.entity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Optional;

public class Note {
    private String surname;
    private String name;
    private String patronymic;
    private String nickname;
    private String comment;
    private Group group;
    private String homePhone;
    private String mobilePhone;
    private Optional<String> secondMobilePhone;
    private String email;
    private String Skype;
    private Address address;
    private ArrayList<DateFormat> ModifyingDates;

}
