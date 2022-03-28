package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.CheckDepartmentIdValidator;
import project.apicapstone.validation.validator.CheckEmployeeIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckDepartmentIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface CheckDepartmentId {
    //    String message() default "Id not valid ! (letter, digit, '-' is valid)";
    String message() default "Mã phòng ban theo định dạng chữ, số và '-'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
