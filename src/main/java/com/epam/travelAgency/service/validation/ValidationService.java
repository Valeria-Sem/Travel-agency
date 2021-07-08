package com.epam.travelAgency.service.validation;

import com.epam.travelAgency.entity.UserRole;

public interface ValidationService {
    boolean isAuthorisationDataValid(String email, String password);
    boolean isRegistrationDataValid(String email, String password, UserRole role);
    boolean isPassportDataValid(String name, String surname, String dateOfBth, String citizenship, String password,
                                String issueDate, String expirationDate);

//    boolean isEmailValid(String email);
//    boolean isNameValid(String name);
//    boolean isSurnameValid(String surname);
//    boolean isPasswordValid(String password);
//    boolean isPassportValid(String passport);
//    boolean isDateValid(String date);
    boolean isSaleValid(String sale);
//    boolean isCitizenshipValid(String citizenship);
//    boolean isBankAccountNumberValid(String ban);
    boolean isBalanceValid(String balance);
//
//    boolean isAdmin (String role);
}
