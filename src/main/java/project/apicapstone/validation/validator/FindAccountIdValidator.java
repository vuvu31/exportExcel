package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.entity.Account;
import project.apicapstone.service.AccountService;
import project.apicapstone.validation.annonation.FindAccountId;
import project.apicapstone.validation.annonation.FindRoleId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindAccountIdValidator implements ConstraintValidator<FindAccountId, String> {
    private String message;
    private AccountService accountService;

    public FindAccountIdValidator(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void initialize(FindAccountId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = accountService.isExisted(id);
//        if (s.isEmpty()) {
//            ValidatorUtils.addError(constraintValidatorContext, "Account Id not blank");
//            return false;
//        }
        if (isExisted) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
