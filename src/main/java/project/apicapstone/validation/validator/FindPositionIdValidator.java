package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.PositionService;
import project.apicapstone.validation.annonation.FindPositionId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindPositionIdValidator implements ConstraintValidator<FindPositionId, String> {
    private String message;
    private PositionService positionService;

    public FindPositionIdValidator(PositionService positionService) {
        this.positionService = positionService;
    }

    @Override
    public void initialize(FindPositionId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = positionService.isExisted(id);
        if (isExisted) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
