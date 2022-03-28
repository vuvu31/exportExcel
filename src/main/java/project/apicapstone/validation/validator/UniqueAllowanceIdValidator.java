package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.AllowanceService;
import project.apicapstone.validation.annonation.UniqueAccountId;
import project.apicapstone.validation.annonation.UniqueAllowanceId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueAllowanceIdValidator implements ConstraintValidator<UniqueAllowanceId, String> {
    private String message;
    private AllowanceService service;

    public UniqueAllowanceIdValidator(AllowanceService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueAllowanceId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = service.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Allowance Id not blank");
            return false;
        }
        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
