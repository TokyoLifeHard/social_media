package ru.em.tt.registration.validations;

import ru.em.tt.registration.annotations.PasswordMatchers;
import ru.em.tt.registration.payload.SingUpRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchersValidator implements ConstraintValidator<PasswordMatchers,Object> {
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        SingUpRequest userSignupRequest = (SingUpRequest) obj;
        System.out.println(userSignupRequest.getPassword().equals(userSignupRequest.getConfirmPassword()));
        return userSignupRequest.getPassword().equals(userSignupRequest.getConfirmPassword());
    }

    @Override
    public void initialize(PasswordMatchers constraintAnnotation) {

    }
}
