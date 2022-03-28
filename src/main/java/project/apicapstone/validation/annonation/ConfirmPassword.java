package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.ConfirmPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface ConfirmPassword {
    String message() default "Mật khẩu không trùng khớp";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
