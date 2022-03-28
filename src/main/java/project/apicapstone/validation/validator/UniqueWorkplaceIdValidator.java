package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.WorkplaceService;
import project.apicapstone.validation.annonation.UniqueAccountId;
import project.apicapstone.validation.annonation.UniqueWorkplaceId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueWorkplaceIdValidator implements ConstraintValidator<UniqueWorkplaceId, String> {
    private String message;
    private WorkplaceService workplaceService;

    public UniqueWorkplaceIdValidator(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @Override
    public void initialize(UniqueWorkplaceId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = workplaceService.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Account Id not blank");
            return false;
        }
        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
