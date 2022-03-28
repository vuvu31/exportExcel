package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.CheckDateValidator;
import project.apicapstone.validation.validator.CheckEmployeeIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Documented
@Constraint(validatedBy = CheckDateValidator.class)
@Retention(RUNTIME)
@Target({FIELD,TYPE})
///////////////////
// Cant' run
////
////
////
//
//
//
//
//
//
public @interface CheckDate {
    String message() default "invalid date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
