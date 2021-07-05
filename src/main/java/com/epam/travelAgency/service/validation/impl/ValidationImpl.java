package com.epam.travelAgency.service.validation.impl;

import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.service.validation.ValidationService;

public class ValidationImpl implements ValidationService {
    public static String userLocale;

    private final static String EMAIL_PATTERN = "[a-zA-Z_.0-9]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}";
    private final static String STRING_PATTERN = "[A-Z]{3,}";
    private final static String PASSWORD_PATTERN = "[a-zA-Z\\d_-]{8,25}";
    private final static String PASSPORT_PATTERN = "[a-zA-Z]+[0-9]{2,7}";
    private final static String SALE_PATTERN = "\\d";
    private final static String BALANCE_PATTERN = "\\d+(\\.\\d+)?";
    private final static String BAN_PATTERN = "^\\w{13}$";
    private final static String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";


    @Override
    public boolean isEmailValid(String email) {
        boolean result = false;
        if (email != null && !email.isEmpty()) {
            result = email.matches(EMAIL_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isNameValid(String name) {
        boolean result = false;
        if (name != null && !name.isEmpty()) {
            result = name.matches(STRING_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isSurnameValid(String surname) {
        boolean result = false;
        if (surname != null && !surname.isEmpty()) {
            result = surname.matches(STRING_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isPasswordValid(String password) {
        boolean result = false;
        if (password != null && !password.isEmpty()) {
            result = password.matches(PASSWORD_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isPassportValid(String passport) {
        boolean result = false;
        if (passport != null && !passport.isEmpty()) {
            result = passport.matches(PASSPORT_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isDateValid(String date) {
        boolean result = false;
        if (date != null && !date.isEmpty() ) {
            result = date.matches(DATE_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isSaleValid(String sale) {
        boolean result = false;
        if (sale != null && !sale.isEmpty() ) {
            result = sale.matches(SALE_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isCitizenshipValid(String citizenship) {
        boolean result = false;
        if (citizenship != null && !citizenship.isEmpty() ) {
            result = citizenship.matches(STRING_PATTERN);
        }
        return result;
    }

    @Override
    public boolean isBankAccountNumberValid(String ban) {
        boolean result = false;
        if (ban != null && !ban.isEmpty() ) {
            result = ban.matches(BAN_PATTERN);
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

    @Override
    public boolean isAdmin(String role) {
        return role.equals(String.valueOf(UserRole.AGENT)) || role.equals(String.valueOf(UserRole.CUSTOMER));
    }
}
