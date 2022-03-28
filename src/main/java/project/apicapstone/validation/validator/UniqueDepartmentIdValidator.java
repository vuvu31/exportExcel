package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.DepartmentService;
import project.apicapstone.service.EmployeeService;
import project.apicapstone.validation.annonation.CheckDepartmentId;
import project.apicapstone.validation.annonation.UniqueDepartmentId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueDepartmentIdValidator implements ConstraintValidator<UniqueDepartmentId, String> {
    private DepartmentService service;
    private String message;

    public UniqueDepartmentIdValidator(DepartmentService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueDepartmentId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = service.isExisted(s);
        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
