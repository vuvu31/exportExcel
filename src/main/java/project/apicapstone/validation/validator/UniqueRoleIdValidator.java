package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.RoleService;
import project.apicapstone.validation.annonation.UniqueRoleId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRoleIdValidator implements ConstraintValidator<UniqueRoleId, String> {
    private String message;
    private RoleService service;

    public UniqueRoleIdValidator(RoleService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueRoleId constraintAnnotation) {
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
