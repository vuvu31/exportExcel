package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.UniqueAccountIdValidator;
import project.apicapstone.validation.validator.UniqueJobPostingIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueJobPostingIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueJobPostingId {
    String message() default "Mã bài đăng bị trùng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
