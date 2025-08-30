package com.hamitherap.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NationalIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NationalId {
    String message() default "کد ملی معتبر نیست";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
