package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.EmployeeService;
import project.apicapstone.validation.annonation.FindEmployeeId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindEmployeeIdValidator implements ConstraintValidator<FindEmployeeId, String> {
    private String message;
    private EmployeeService employeeService;

    public FindEmployeeIdValidator(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void initialize(FindEmployeeId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = employeeService.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Employee Id not blank");
            return false;
        }
        if (isExisted) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
