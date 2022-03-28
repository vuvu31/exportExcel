package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.TitleService;
import project.apicapstone.validation.annonation.FindEmployeeId;
import project.apicapstone.validation.annonation.FindTitleId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FindTitleIdValidator implements ConstraintValidator<FindTitleId, String> {
    private String message;
    private TitleService titleService;
    public FindTitleIdValidator(TitleService titleService){
        this.titleService=titleService;
    }
    @Override
    public void initialize(FindTitleId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = titleService.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Title Id not blank");
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
