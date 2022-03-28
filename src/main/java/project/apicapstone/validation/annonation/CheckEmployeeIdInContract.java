package project.apicapstone.validation.annonation;


import project.apicapstone.validation.validator.CheckEmployeeIdInContractValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.TYPE;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckEmployeeIdInContractValidator.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface CheckEmployeeIdInContract {
    String message() default "Employee Id đã được sử dụng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
