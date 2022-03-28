package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.validation.annonation.CheckDepartmentId;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDepartmentIdValidator implements ConstraintValidator<CheckDepartmentId,String> {
    private String message;
    @Override
    public void initialize(CheckDepartmentId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.isEmpty()){
            ValidatorUtils.addError(constraintValidatorContext, "Deparment Id not blank !");
            return false;
        }
        if (!s.matches("[a-zA-Z0-9\\-]*$") ) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        }
        return true;
    }
}
