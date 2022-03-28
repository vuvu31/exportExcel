package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.AccountService;
import project.apicapstone.validation.annonation.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private String message;
    private AccountService service;

    public UniqueUsernameValidator(AccountService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExistedUsername = service.isExistedUsername(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Username not blank");
            return false;
        }
        if (isExistedUsername) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
