package com.hamitherap.user.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NationalIdValidator implements ConstraintValidator<NationalId, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        if (!value.matches("\\d{10}")) {
            return false;
        }

        char firstChar = value.charAt(0);
        boolean allSame = true;
        for (int i = 1; i < value.length(); i++) {
            if (value.charAt(i) != firstChar) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            return false;
        }

        int[] digits = new int[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = Character.getNumericValue(value.charAt(i));
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }

        int remainder = sum % 11;
        int checkDigit = digits[9];

        if (remainder < 2) {
            return checkDigit == remainder;
        } else {
            return checkDigit == (11 - remainder);
        }
    }
}