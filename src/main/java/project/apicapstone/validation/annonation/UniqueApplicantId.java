package project.apicapstone.validation.annonation;

import project.apicapstone.validation.validator.UniqueApplicantIdValidator;
import project.apicapstone.validation.validator.UniqueContractIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniqueApplicantIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueApplicantId {
    String message() default "Mã người xin việc bị trùng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
