package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.dto.employee.CreateEmployeeDto;
import project.apicapstone.service.EmployeeService;
import project.apicapstone.validation.annonation.CheckEmployeeId;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmployeeIdValidator implements ConstraintValidator<CheckEmployeeId,String> {
    private String message;

    @Override
    public void initialize(CheckEmployeeId constraintAnnotation) {
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
