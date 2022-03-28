package project.apicapstone.validation.validator;


import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.AreaService;
import project.apicapstone.validation.annonation.UniqueAreaId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueAreaIdValidator implements ConstraintValidator<UniqueAreaId, String> {
    private String message;
    private AreaService areaService;

    public UniqueAreaIdValidator(AreaService areaService) {
        this.areaService = areaService;
    }

    @Override
    public void initialize(UniqueAreaId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = areaService.isExisted(s);

        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
