package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.validation.annonation.CheckEmployeeId;
import project.apicapstone.validation.annonation.CheckPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPhoneNumberValidator implements ConstraintValidator<CheckPhoneNumber,String> {
    private String message;
    @Override
    public void initialize(CheckPhoneNumber constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String check, ConstraintValidatorContext constraintValidatorContext) {
        if (!check.matches("[0-9]{1,12}")) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        }
        return true;
    }
}
