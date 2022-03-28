package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.FindAccountIdValidator;
import project.apicapstone.validation.validator.FindAreaIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = FindAreaIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface FindAreaId {
    String message() default "Không tìm thấy mã vùng phụ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
