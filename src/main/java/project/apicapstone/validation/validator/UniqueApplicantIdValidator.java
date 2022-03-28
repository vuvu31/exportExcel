package project.apicapstone.validation.validator;

import project.apicapstone.common.util.ValidatorUtils;
import project.apicapstone.service.ApplicantService;
import project.apicapstone.validation.annonation.UniqueApplicantId;
import project.apicapstone.validation.annonation.UniqueContractId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueApplicantIdValidator implements ConstraintValidator<UniqueApplicantId, String> {
    private String message;
    private ApplicantService service;

    public UniqueApplicantIdValidator(ApplicantService service) {
        this.service = service;
    }

    @Override
    public void initialize(UniqueApplicantId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExisted = service.isExisted(s);
        if (s.isEmpty()) {
            ValidatorUtils.addError(constraintValidatorContext, "Applicant Id not blank");
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
