package project.apicapstone.validation.validator;


import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.WorkplaceService;
import project.apicapstone.validation.annonation.FindWorkPlaceId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindWorkPlaceIdValidator implements ConstraintValidator<FindWorkPlaceId, String> {
    private String message;
    private WorkplaceService workplaceService;
    public FindWorkPlaceIdValidator(WorkplaceService workplaceService){
        this.workplaceService=workplaceService;
    }
    @Override
    public void initialize(FindWorkPlaceId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = workplaceService.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Mã nơi làm việc không rỗng");
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
