package ru.em.tt.registration.annotations;

import ru.em.tt.registration.validations.PasswordMatchersValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchersValidator.class)
public @interface PasswordMatchers {
    String message() default "Password dont match";
    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
