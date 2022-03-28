package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.UniqueRoleIdValidator;
import project.apicapstone.validation.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueUsername {
    String message() default "Tài khoản đăng nhập bị trùng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
