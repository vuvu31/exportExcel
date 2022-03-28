package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.DepartmentService;
import project.apicapstone.validation.annonation.FindAccountId;
import project.apicapstone.validation.annonation.FindDepartmentId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindDepartmentIdValidator implements ConstraintValidator<FindDepartmentId, String> {
    private String message;
    private DepartmentService departmentService;

    public FindDepartmentIdValidator(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void initialize(FindDepartmentId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = departmentService.isExisted(id);

        if (isExisted) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
