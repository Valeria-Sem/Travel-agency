package com.epam.travelAgency.service.validation;

public interface ValidationService {
    boolean isEmailValid(String email);
    boolean isNameValid(String name);
    boolean isSurnameValid(String surname);
    boolean isPasswordValid(String password);
    boolean isPassportValid(String passport);
    boolean isDateValid(String date);
    boolean isSaleValid(String sale);
    boolean isCitizenshipValid(String citizenship);
    boolean isBankAccountNumberValid(String ban);
    boolean isBalanceValid(String balance);

    boolean isAdmin (String role);
}
