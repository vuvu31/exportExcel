package project.apicapstone.validation.validator;



import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.AreaService;
import project.apicapstone.validation.annonation.FindAreaId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindAreaIdValidator implements ConstraintValidator<FindAreaId, String> {
    private String message;
    private AreaService areaService;
    public FindAreaIdValidator(AreaService areaService){
        this.areaService=areaService;
    }
    @Override
    public void initialize(FindAreaId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = areaService.isExisted(s);
//        if (s.isEmpty()) {
//            ValidatorUtils.addError(constraintValidatorContext, "Account Id not blank");
//            return false;
//        }
        if (isExisted) {
            return true;
        } else {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;

        }
    }
}
