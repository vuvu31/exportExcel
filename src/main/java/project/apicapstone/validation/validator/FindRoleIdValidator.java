package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.RoleService;
import project.apicapstone.validation.annonation.FindRoleId;
import project.apicapstone.validation.annonation.UniqueContractId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindRoleIdValidator implements ConstraintValidator<FindRoleId, String> {
    private String message;
    private RoleService roleService;

    public FindRoleIdValidator(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void initialize(FindRoleId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = roleService.isExisted(s);

        if (isExisted) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
