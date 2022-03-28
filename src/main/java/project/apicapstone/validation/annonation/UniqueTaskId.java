package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.UniqueTaskIdValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueTaskIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueTaskId {
    String message() default "Mã nhiệm vụ bị trùng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
