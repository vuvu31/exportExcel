package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.TaskService;
import project.apicapstone.validation.annonation.UniqueTaskId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueTaskIdValidator implements ConstraintValidator<UniqueTaskId, String> {
    private String message;
    private TaskService service;
    public UniqueTaskIdValidator(TaskService service){
        this.service=service;
    }
    @Override
    public void initialize(UniqueTaskId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = service.isExisted(s);

        if (isExisted) {
            ValidatorUtils.addError(constraintValidatorContext, message);
            return false;
        } else {
            return true;
        }
    }
}
