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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Optional<String> getSecondMobilePhone() {
        return secondMobilePhone;
    }

    public void setSecondMobilePhone(Optional<String> secondMobilePhone) {
        this.secondMobilePhone = secondMobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return Skype;
    }

    public void setSkype(String skype) {
        Skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(int index, String city, String street, int houseNumber, int flatNumber) {
        this.address = new Address(index, city, street, houseNumber, flatNumber);
    }

    public ArrayList<DateFormat> getModifyingDates() {
        return ModifyingDates;
    }

    public void setModifyingDates(ArrayList<DateFormat> modifyingDates) {
        ModifyingDates = modifyingDates;
    }

    @Override
    public String toString() {
        return "Note{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", group=" + group +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", secondMobilePhone=" + secondMobilePhone +
                ", email='" + email + '\'' +
                ", Skype='" + Skype + '\'' +
                ", address=" + address +
                ", ModifyingDates=" + ModifyingDates +
                '}';
    }
}
