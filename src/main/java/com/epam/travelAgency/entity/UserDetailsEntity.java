package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserDetailsEntity implements Serializable {
    private int id;
    private int idUser;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String citizenship;
    private String passport;
    private LocalDate dateOfIssue;
    private LocalDate expirationDate;

    public UserDetailsEntity() {
    }

    public UserDetailsEntity(int id, int idUser, String name,
                             String surname, LocalDate dateOfBirth,
                             String citizenship, String passport,
                             LocalDate dateOfIssue, LocalDate expirationDate) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.citizenship = citizenship;
        this.passport = passport;
        this.dateOfIssue = dateOfIssue;
        this.expirationDate = expirationDate;
    }

    public UserDetailsEntity(int idUser, String name,
                             String surname, LocalDate dateOfBirth,
                             String citizenship, String passport,
                             LocalDate dateOfIssue, LocalDate expirationDate) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.citizenship = citizenship;
        this.passport = passport;
        this.dateOfIssue = dateOfIssue;
        this.expirationDate = expirationDate;
    }

    public UserDetailsEntity(String name,
                             String surname, LocalDate dateOfBirth,
                             String citizenship, String passport,
                             LocalDate dateOfIssue, LocalDate expirationDate) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsEntity that = (UserDetailsEntity) o;
        return id == that.id && idUser == that.idUser && name.equals(that.name) && surname.equals(that.surname)
                && dateOfBirth.equals(that.dateOfBirth) && citizenship.equals(that.citizenship)
                && passport.equals(that.passport) && dateOfIssue.equals(that.dateOfIssue)
                && expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, name, surname, dateOfBirth, citizenship, passport, dateOfIssue, expirationDate);
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
                ", expirationDate='" + expirationDate +
                '}';
    }
}
