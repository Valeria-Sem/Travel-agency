package com.epam.travelAgency.entity;

import java.util.Objects;

public class UserDetailsEntity {
    private int id;
    private int idUser;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String citizenship;
    private String passport;
    private String dateOfIssue;
    private String expirationDate;
    private int idWallet;

    public UserDetailsEntity() {
    }

    public UserDetailsEntity(int id, int idUser, String name,
                             String surname, String dateOfBirth,
                             String citizenship, String passport,
                             String dateOfIssue, String expirationDate,
                             int idWallet) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.citizenship = citizenship;
        this.passport = passport;
        this.dateOfIssue = dateOfIssue;
        this.expirationDate = expirationDate;
        this.idWallet = idWallet;
    }

    public UserDetailsEntity(int idUser, String name,
                             String surname, String dateOfBirth,
                             String citizenship, String passport,
                             String dateOfIssue, String expirationDate,
                             int idWallet) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.citizenship = citizenship;
        this.passport = passport;
        this.dateOfIssue = dateOfIssue;
        this.expirationDate = expirationDate;
        this.idWallet = idWallet;
    }

    public UserDetailsEntity(String name,
                             String surname, String dateOfBirth,
                             String citizenship, String passport,
                             String dateOfIssue, String expirationDate) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.citizenship = citizenship;
        this.passport = passport;
        this.dateOfIssue = dateOfIssue;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsEntity that = (UserDetailsEntity) o;
        return id == that.id && idUser == that.idUser && idWallet == that.idWallet && name.equals(that.name) && surname.equals(that.surname) && dateOfBirth.equals(that.dateOfBirth) && citizenship.equals(that.citizenship) && passport.equals(that.passport) && dateOfIssue.equals(that.dateOfIssue) && expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, name, surname, dateOfBirth, citizenship, passport, dateOfIssue, expirationDate, idWallet);
    }

    @Override
    public String toString() {
        return "UserDetailsEntity{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", passport='" + passport + '\'' +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", idWallet=" + idWallet +
                '}';
    }
}
