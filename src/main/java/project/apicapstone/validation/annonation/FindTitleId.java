package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.FindEmployeeIdValidator;
import project.apicapstone.validation.validator.FindTitleIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = FindTitleIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface FindTitleId {
    String message() default "Mã chức vụ không tìm thấy";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
