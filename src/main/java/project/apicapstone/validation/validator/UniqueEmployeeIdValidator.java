package project.apicapstone.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.EmployeeService;
import project.apicapstone.validation.annonation.UniqueEmployeeId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmployeeIdValidator implements ConstraintValidator<UniqueEmployeeId, String> {

    private EmployeeService service;
    private String message;

    public UniqueEmployeeIdValidator(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueEmployeeId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = service.isExisted(id);

        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
