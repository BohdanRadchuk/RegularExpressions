package model.entity;

import view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Note {
    private String surname;
    private String name;
    private String patronymic;
    private String surnameAndInitial;
    private String nickname;
    private String comment;
    private Group group;
    private String homePhone;
    private String mobilePhone;
    private Optional<String> secondMobilePhone;
    private String email;
    private String skype;
    private Address address;
    private ArrayList<Date> modifyingDates = new ArrayList<>();

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setSecondMobilePhone(Optional<String> secondMobilePhone) {
        this.secondMobilePhone = secondMobilePhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setAddress(int index, String city, String street, int houseNumber, int flatNumber) {
        this.address = new Address(index, city, street, houseNumber, flatNumber);
    }

    public void addModifyingDates(Date date) {
        modifyingDates.add(date);
    }

    public void generateSurnameAndInitial() {
        this.surnameAndInitial = String.format(View.INITIAL_PATTERN, surname, name.substring(0, 1));
    }

    @Override
    public String toString() {
        return "Note{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surnameAndInitial='" + surnameAndInitial + '\'' +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", group=" + group +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", secondMobilePhone=" + secondMobilePhone +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", modifyingDates=" + modifyingDates +
                '}';
    }
}
