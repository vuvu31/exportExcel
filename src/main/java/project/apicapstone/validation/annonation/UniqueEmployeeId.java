package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.UniqueEmployeeIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueEmployeeIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmployeeId {
    String message() default "Mã nhân viên bị trùng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
