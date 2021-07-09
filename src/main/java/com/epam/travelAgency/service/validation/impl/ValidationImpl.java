package com.epam.travelAgency.service.validation.impl;

import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.service.validation.ValidationService;

public class ValidationImpl implements ValidationService {
    public static String userLocale;

    private final static String EMAIL_PATTERN = "[a-zA-Z_.0-9]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}";
    private final static String STRING_PATTERN = "[a-zA-Z]{3,}";
    private final static String PASSWORD_PATTERN = "[a-zA-Z\\d_-]{8,25}";
    private final static String PASSPORT_PATTERN = "[a-zA-Z]+[0-9]{2,7}";
    private final static String SALE_PATTERN = "\\d";
    private final static String BALANCE_PATTERN = "\\d+(\\.\\d+)?";
    private final static String CITIZENSHIP_PATTERN = "[a-zA-Z ]*";
    private final static String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    private final static int MAX_SALE = 20;

    @Override
    public boolean isAuthorisationDataValid(String email, String password) {
        return isEmailValid(email) && isPasswordValid(password);
    }

    @Override
    public boolean isRegistrationDataValid(String email, String password, UserRole role) {
        return isEmailValid(email) && isPasswordValid(password) && role == UserRole.CUSTOMER;
    }

    @Override
    public boolean isPassportDataValid(String name, String surname, String dateOfBth,
                                       String citizenship, String passport,
                                       String issueDate, String expirationDate) {
        return isNameValid(name) && isSurnameValid(surname)
                && isDateValid(dateOfBth) && isCitizenshipValid(citizenship)
                && isPassportValid(passport) && isDateValid(issueDate) && isDateValid(expirationDate);
    }

    @Override
    public boolean isSaleValid(String sale) {
        boolean result = false;

        if (sale != null && !sale.isEmpty() ) {
            result = sale.matches(SALE_PATTERN) && Integer.parseInt(sale) < MAX_SALE;
        }

        return result;
    }

    @Override
    public boolean isBalanceValid(String balance) {
        boolean result = false;

        if (balance != null && !balance.isEmpty() ) {
            result = balance.matches(BALANCE_PATTERN);
        }

        return result;
    }

    public boolean isEmailValid(String email) {
        boolean result = false;

        if (email != null && !email.isEmpty()) {
            result = email.matches(EMAIL_PATTERN);
        }

        return result;
    }

    public boolean isNameValid(String name) {
        boolean result = false;

        if (name != null && !name.isEmpty()) {
            result = name.matches(STRING_PATTERN);
        }

        return result;
    }

    public boolean isSurnameValid(String surname) {
        boolean result = false;

        if (surname != null && !surname.isEmpty()) {
            result = surname.matches(STRING_PATTERN);
        }

        return result;
    }

    public boolean isPasswordValid(String password) {
        boolean result = false;

        if (password != null && !password.isEmpty()) {
            result = password.matches(PASSWORD_PATTERN);
        }

        return result;
    }

    public boolean isPassportValid(String passport) {
        boolean result = false;

        if (passport != null && !passport.isEmpty()) {
            result = passport.matches(PASSPORT_PATTERN);
        }

        return result;
    }

    public boolean isDateValid(String date) {
        boolean result = false;

        if (date != null && !date.isEmpty() ) {
            result = date.matches(DATE_PATTERN);
        }

        return result;
    }



    public boolean isCitizenshipValid(String citizenship) {
        boolean result = false;

        if (citizenship != null && !citizenship.isEmpty() ) {
            result = citizenship.matches(CITIZENSHIP_PATTERN);
        }

        return result;
    }
}
