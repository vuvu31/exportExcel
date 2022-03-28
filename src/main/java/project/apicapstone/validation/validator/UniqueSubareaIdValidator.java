package project.apicapstone.validation.validator;


import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.SubareaService;
import project.apicapstone.validation.annonation.UniqueSubareaId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueSubareaIdValidator implements ConstraintValidator<UniqueSubareaId, String> {
    private String message;
    private SubareaService subareaService;
    public UniqueSubareaIdValidator(SubareaService subareaService){
        this.subareaService=subareaService;
    }
    @Override
    public void initialize(UniqueSubareaId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = subareaService.isExisted(s);

        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
