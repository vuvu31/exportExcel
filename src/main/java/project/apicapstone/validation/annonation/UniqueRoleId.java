package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.UniqueEmployeeIdValidator;
import project.apicapstone.validation.validator.UniqueRoleIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueRoleIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueRoleId {
    String message() default "Mã vai trò bị trùng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
