package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.FindAccountIdValidator;
import project.apicapstone.validation.validator.FindSubareaIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = FindSubareaIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface FindSubareaId {
    String message() default "Mã vùng phụ không tìm thấy";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
